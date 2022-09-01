package net.balance.push.getui.autoconfigure;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.util.StrUtil;
import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import net.balance.push.getui.consts.GeTuiConst;
import net.balance.push.getui.properties.GeTuiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * 个推推送自动配置类
 *
 * @author : ShuLiu
 * @date : 04 : 07 : 2022/7/4
 */
@EnableConfigurationProperties(GeTuiProperties.class)
@AutoConfiguration
public class BalanceGeTuiPushAutoConfiguration {

	private final Logger logger = LoggerFactory.getLogger(BalanceGeTuiPushAutoConfiguration.class);

	/**
	 * 初始化个推推送 配置对象
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public GeTuiProperties geTuiProperties(final GeTuiProperties properties) {
		// 检查必要参数
		if (properties == null || properties.isEmpty()) {
			logger.warn("【个推推送自动化配置】未检测到个推推送相关配置、如需使用请前去配置。若无需使用 请排除：BalanceGeTuiPushAutoConfiguration.class");
		} else {
			ForestConfiguration config = Forest.config();
			// 设置连接池最大连接数
			config.setMaxConnections(properties.getMaxConnections() <= 0 ? 500 : properties.getMaxConnections());
			// 设置连接超时时间
			config.setConnectTimeout(properties.getConnectTimeout() <= 0 ? 500 : properties.getConnectTimeout());
			// 设置数据读取超时时间
			config.setReadTimeout(properties.getReadTimeout() == null || properties.getReadTimeout() <= 0 ? 3000 : properties.getReadTimeout());
			// 设置日志是否启用
			config.setLogEnabled(properties.isLogEnabled());
			// 若不使用本地存储则检查对Redis进行连接
			if (!properties.isLocalStorage()) {
				int redisDBNum = properties.getRedisDBNum();
				if (redisDBNum < 0 || redisDBNum > 15) {
					// 非法的数据库 默认选择0
					properties.setRedisDBNum(0);
					logger.warn("【个推推送自动化配置】Redis数据库集非法、已默认选择Database0");
				}
			}
			// 缓存键名非法
			if (StrUtil.isBlank(properties.getGetuiTokenName())) {
				properties.setGetuiTokenName(GeTuiConst.BALANCE_GETUI_TOKEN_PREFIX);
				logger.warn("【个推推送自动化配置】个推Token鉴权名称Key键名无效、已默认定义:{}", GeTuiConst.BALANCE_GETUI_TOKEN_PREFIX);
			}
		}
		return properties;
	}

	/**
	 * 获取个推自定义Redis实例
	 *
	 * @param properties 配置内容
	 * @return Jedis
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public Jedis getuiRedis(final GeTuiProperties properties) {
		if (!properties.isLocalStorage()) {
			final JedisPoolConfig config = new JedisPoolConfig();
			// 最大连接空闲数
			config.setMaxIdle(properties.getRedisMaxIdle());
			// 最大连接数
			config.setMaxTotal(properties.getRedisMaxTotal());
			final List<String> redisHost = StrUtil.split(properties.getRedisHost(), StrUtil.C_COLON);

			if (redisHost.size() != 2) {
				logger.error("【个推推送自动化配置】错误的Redis实例地址:{}", properties.getRedisHost());
				return null;
			}

			JedisPool jedisPool = null;
			try {
				jedisPool = new JedisPool(config, redisHost.get(0), Integer.valueOf(redisHost.get(1)));
			} catch (Exception e) {
				logger.error("【个推推送自动化配置】无法链接redis实例:{}", e.getMessage());
			} finally {
				if (jedisPool != null) {
					jedisPool.close();
				}
			}
			return jedisPool.getResource();
		}
		return null;
	}

	/**
	 * 获取个推本地缓存实例
	 * 注意: 数据会持久化到当前内存,该方法不适于分布式业务.
	 *
	 * @return TimedCache<String, String>
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public TimedCache<String, String> getuiLocalStorage(final GeTuiProperties properties) {
		if (properties.isLocalStorage()) {
			long tokenCacheTimeOut = properties.getTokenCacheTimeOut();
			if (tokenCacheTimeOut <= 0 || tokenCacheTimeOut >= GeTuiConst.GETUI_TOKEN_MAX_TIME_OUT) {
				properties.setTokenCacheTimeOut(GeTuiConst.GETUI_TOKEN_TIME_OUT);
				logger.warn("【个推推送自动化配置】Token存活时间非法、已默认选择{}毫秒", GeTuiConst.GETUI_TOKEN_TIME_OUT);
			}
			return CacheUtil.newTimedCache(properties.getTokenCacheTimeOut());
		}
		return null;
	}
}

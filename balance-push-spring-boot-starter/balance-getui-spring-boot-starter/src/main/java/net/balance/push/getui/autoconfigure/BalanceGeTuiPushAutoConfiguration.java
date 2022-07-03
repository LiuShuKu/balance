package net.balance.push.getui.autoconfigure;

import com.dtflys.forest.springboot.properties.ForestConfigurationProperties;
import net.balance.push.getui.properties.GeTuiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * 个推推送自动配置类
 *
 * @author : ShuLiu
 * @date : 04 : 07 : 2022/7/4
 */
@EnableConfigurationProperties(GeTuiProperties.class)
@AutoConfiguration
public class BalanceGeTuiPushAutoConfiguration {

	@Resource
	private ForestConfigurationProperties forestConfigurationProperties;

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
			// 设置连接池最大连接数
			forestConfigurationProperties.setMaxConnections(properties.getMaxConnections() <= 0 ? 500 : properties.getMaxConnections());
			// 设置连接超时时间
			forestConfigurationProperties.setConnectTimeout(properties.getConnectTimeout() <= 0 ? 500 : properties.getConnectTimeout());
			// 设置数据读取超时时间
			forestConfigurationProperties.setReadTimeout(properties.getReadTimeout() == null || properties.getReadTimeout() <= 0 ? 3000 : properties.getReadTimeout());
			// 设置日志是否启用
			forestConfigurationProperties.setLogEnabled(properties.isLogEnabled());
		}
		return properties;
	}
}

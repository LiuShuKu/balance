package net.balance.push.getui.util;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.crypto.SecureUtil;
import com.dtflys.forest.Forest;
import net.balance.push.getui.consts.GeTuiConst;
import net.balance.push.getui.properties.GeTuiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 个推鉴权类
 *
 * @author : ShuLiu
 * @date : 04 : 07 : 2022/7/4
 */
@Component
public class GeTuiAuth {

	private final Logger logger = LoggerFactory.getLogger(GeTuiAuth.class);

	@Resource
	private GeTuiProperties geTuiProperties;

	@SuppressWarnings("all")
	@Autowired(required = false)
	private Jedis getuiRedis;

	@SuppressWarnings("all")
	@Autowired(required = false)
	private TimedCache<String, String> getuiLocalStorage;

	/**
	 * 获取个推Token
	 *
	 * @return token信息
	 */
	public String getToken() {

		final String tokenName = geTuiProperties.getGetuiTokenName();

		if (geTuiProperties.isLocalStorage()) {
			if (!getuiLocalStorage.isEmpty()) {
				return getuiLocalStorage.get(tokenName);
			}
		} else {
			if (getuiRedis.exists(tokenName)) {
				return getuiRedis.get(tokenName);
			}
		}
		return auth();
	}

	/**
	 * 获取认证Token、并设置存储
	 *
	 * @return token 信息
	 */
	private String auth() {
		final String requestUrl = geTuiProperties.getBaseUrl() + geTuiProperties.getAppId() + "/auth";

		final long timestamp = System.currentTimeMillis();

		final String sign = SecureUtil.sha256(geTuiProperties.getAppKey() + timestamp + geTuiProperties.getMasterSecret());

		final Map<Object, Object> result = Forest.post(requestUrl).contentType(GeTuiConst.CONTENT_TYPE).addBody("sign", sign).addBody("timestamp", timestamp).addBody("appkey", geTuiProperties.getAppKey()).onError((ex, req, res) -> {
			logger.error("【个推推送】权限认证失败:{}", ex.getMessage());
		}).executeAsMap();

		// 数据检查
		{
			if (result == null) {
				logger.error("【个推推送】权限认证失败、无法获取token、返回结果是空的");
				return "";
			}

			final int code = (int) result.get("code");
			if (code != 0) {
				logger.error("【个推推送】权限认证失败、响应code:{},响应消息{}", code, result.get("msg"));
				return "";
			}
		}


		// 设置缓存
		final Map<String, String> data = (Map) result.get("data");
		final String token = data.get("token");

		{
			if (geTuiProperties.isLocalStorage()) {
				getuiLocalStorage.put(geTuiProperties.getGetuiTokenName(), token);
			} else {
				getuiRedis.psetex(geTuiProperties.getGetuiTokenName(), GeTuiConst.GETUI_TOKEN_TIME_OUT, token);
			}
		}

		return token;
	}
}

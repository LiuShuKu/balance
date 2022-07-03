package net.balance.push.getui.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 读取个推配置文件 <br>
 * <p>
 * 官方文档: <br>
 * <a href="https://docs.getui.com/getui/server/rest_v2/introduction/">...</a>
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@Data
@ConfigurationProperties(prefix = "balance.push.getui")
public class GeTuiProperties {

	/**
	 * App Id : 必填参数
	 */
	private String appId;

	/**
	 * App Key : 必填参数
	 */
	private String appKey;

	/**
	 * App Secret : 必填参数
	 */
	private String appSecret;

	/**
	 * Master Secret : 必填参数
	 */
	private String masterSecret;

	/**
	 * 连接池最大连接数 : 默认为 500
	 */
	private int maxConnections = 500;

	/**
	 * 连接超时时间,单位为毫秒 : 每个路由的最大连接数（默认为 500）
	 */
	private Integer connectTimeout = 500;

	/**
	 * 数据读取超时时间，单位为毫秒 : 默认3000
	 */
	private Integer readTimeout = 3000;

	/**
	 * 是否启用请求日志: 默认开启
	 */
	private boolean logEnabled = true;

	/**
	 * 个推开放平台接口前缀(BaseUrl)
	 */
	private final String baseUrl = "https://restapi.getui.com/v2/" + appId;


	public GeTuiProperties() {
	}

	public GeTuiProperties(String appId, String appKey, String appSecret, String masterSecret) {
		this.appId = appId;
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.masterSecret = masterSecret;
	}

	public boolean isEmpty() {
		return this.appId == null || this.appKey == null || this.appSecret == null || masterSecret == null;
	}
}

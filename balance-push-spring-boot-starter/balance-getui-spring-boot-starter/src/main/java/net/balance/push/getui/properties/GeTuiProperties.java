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
	 * 是否暂存于本地缓存<br/>
	 * 若暂存于当前缓存中、则不需要配置Redis
	 */
	private boolean localStorage = true;

	/**
	 * redis 地址<br/>
	 * 如: 127.0.0.1:6379
	 */
	private String redisHost = "127.0.0.1:6379";

	/**
	 * redis 密码<br/>
	 * 没有则不填
	 */
	private String redisPassWord;

	/**
	 * redis 数据库选择<br/>
	 * 默认DB0
	 */
	private int redisDBNum = 0;

	/**
	 * Redis 最大链接数量<br/>
	 * 默认 30
	 */
	private int redisMaxTotal = 30;

	/**
	 * Redis 最大链接空闲数量<br/>
	 * 默认 5
	 */
	private int redisMaxIdle = 5;

	/**
	 * 个推Token在Redis中的Key名称
	 */
	private String getuiTokenName;

	/**
	 * 个推Token默认存活时间
	 */
	private long tokenCacheTimeOut = 3 * 1000 * 60 * 60;

	/**
	 * 个推开放平台接口前缀(BaseUrl)
	 */
	private final String baseUrl = "https://restapi.getui.com/v2/";


	public GeTuiProperties() {
	}

	public GeTuiProperties(String appId, String appKey, String appSecret, String masterSecret, int maxConnections, Integer connectTimeout, Integer readTimeout, boolean logEnabled, boolean localStorage, String redisHost, String redisPassWord, int redisDBNum, int redisMaxTotal, int redisMaxIdle, String getuiTokenName) {
		this.appId = appId;
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.masterSecret = masterSecret;
		this.maxConnections = maxConnections;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.logEnabled = logEnabled;
		this.localStorage = localStorage;
		this.redisHost = redisHost;
		this.redisPassWord = redisPassWord;
		this.redisDBNum = redisDBNum;
		this.redisMaxTotal = redisMaxTotal;
		this.redisMaxIdle = redisMaxIdle;
		this.getuiTokenName = getuiTokenName;
	}

	public boolean isEmpty() {
		return this.appId == null || this.appKey == null || this.appSecret == null || masterSecret == null;
	}
}

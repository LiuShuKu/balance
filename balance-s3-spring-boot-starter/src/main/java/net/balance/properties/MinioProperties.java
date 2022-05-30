package net.balance.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

/**
 * 读取minio配置 <br>
 *
 * 官方文档: <br>
 * 		http://docs.minio.org.cn/docs/master/java-client-quickstart-guide
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@Component
@ConfigurationProperties(prefix = "balance.s3.minio")
public class MinioProperties {

	/**
	 * 对象存储服务的URL
	 */
	private String endpoint;

	/**
	 * Access key就像用户ID，可以唯一标识你的账户。
	 */
	private String accessKey;

	/**
	 * Secret key是你账户的密码。
	 */
	private String  secretKey;


	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}

package net.balance.s3.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 读取minio配置 <br>
 * <p>
 * 官方文档: <br>
 * http://docs.minio.org.cn/docs/master/java-client-quickstart-guide
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@ConfigurationProperties(prefix = "balance.s3.minio")
public class MinioProperties {


	public MinioProperties(String endpoint, String accessKey, String secretKey) {
		this.endpoint = endpoint;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}


	public MinioProperties() {
	}

	/**
	 * URL
	 */
	private String endpoint;

	/**
	 * Access key
	 */
	private String accessKey;

	/**
	 * Secret key
	 */
	private String secretKey;


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


	@Override
	public String toString() {
		return "Balance-MinioProperties{" + "endpoint='" + endpoint + '\'' + ", accessKey='" + accessKey + '\'' + ", secretKey='" + secretKey + '\'' + '}';
	}

}

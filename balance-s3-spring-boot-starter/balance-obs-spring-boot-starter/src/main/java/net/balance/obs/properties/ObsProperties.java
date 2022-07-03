package net.balance.obs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 读取obs配置 <br>
 * <p>
 * 官方文档: <br>
 * <a href="https://support.huaweicloud.com/sdk-java-devg-obs/obs_21_0102.html">...</a>
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@Data
@ConfigurationProperties(prefix = "balance.s3.obs")
public class ObsProperties {

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

	/**
	 * 存储桶名称(选填)
	 * <p>
	 * 若不为空则默认采用此桶
	 */
	private String bucketName;

	public ObsProperties(String endpoint, String accessKey, String secretKey, String bucketName) {
		this.endpoint = endpoint;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.bucketName = bucketName;
	}

	public ObsProperties() {
	}

	public boolean isEmpty() {
		return this.accessKey == null || this.secretKey == null || this.endpoint == null;
	}
}

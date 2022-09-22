package net.balance.obs.properties;

import cn.hutool.core.util.StrUtil;
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

	/**
	 * 全参构造方法
	 *
	 * @param endpoint   endpoint
	 * @param accessKey  accessKey
	 * @param secretKey  secretKey
	 * @param bucketName 存储桶名称
	 */
	protected ObsProperties(String endpoint, String accessKey, String secretKey, String bucketName) {
		this.endpoint = endpoint;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.bucketName = bucketName;
	}

	/**
	 * 无参构造
	 */
	private ObsProperties() {
	}

	/**
	 * 检查对象是否为空
	 *
	 * @return null -> true; not null -> false
	 */
	public boolean isEmpty() {
		return StrUtil.hasBlank(this.accessKey, this.secretKey, this.endpoint);
	}
}

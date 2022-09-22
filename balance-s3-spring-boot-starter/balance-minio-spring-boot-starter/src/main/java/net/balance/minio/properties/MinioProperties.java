package net.balance.minio.properties;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 读取minio配置 <br>
 * <p>
 * 官方文档: <br>
 * <a href="http://docs.minio.org.cn/docs/master/java-client-quickstart-guide">...</a>
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@Data
@ConfigurationProperties(prefix = "balance.s3.minio")
public class MinioProperties {
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
	 * 全参构造
	 *
	 * @param endpoint   URL
	 * @param accessKey  Access key
	 * @param secretKey  Secret key
	 * @param bucketName 存储桶名称
	 */
	protected MinioProperties(String endpoint, String accessKey, String secretKey, String bucketName) {
		this.endpoint = endpoint;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.bucketName = bucketName;
	}

	/**
	 * 无参构造
	 */
	private MinioProperties() {
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

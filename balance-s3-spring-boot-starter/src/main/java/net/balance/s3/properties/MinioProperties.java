package net.balance.s3.properties;

import lombok.Data;
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
	 * 存储桶名称
	 */
	private String bucketName;

}

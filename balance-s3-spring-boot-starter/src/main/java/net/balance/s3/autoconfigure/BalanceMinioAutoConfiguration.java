package net.balance.s3.autoconfigure;

import io.minio.MinioClient;
import net.balance.s3.properties.MinioProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Minio配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@AutoConfiguration
@EnableConfigurationProperties(MinioProperties.class)
public class BalanceMinioAutoConfiguration {

	private final Logger logger = LoggerFactory.getLogger(BalanceMinioAutoConfiguration.class);

	/**
	 * 初始化Minio 配置对象
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public MinioProperties minioProperties(final MinioProperties properties) {
		if (properties == null || properties.isEmpty()) {
			logger.warn("【Minio自动化配置】未检测到minio相关配置、如需使用请前去配置。若无需使用 请排除：BalanceMinioAutoConfiguration.class");
		}
		return properties;
	}

	/**
	 * 初始化Minio 客户端
	 */
	@Bean
	@ConditionalOnMissingBean
	public MinioClient minioClient(final MinioProperties properties) {
		if (properties == null || properties.isEmpty()) {
			logger.warn("【Minio自动化配置】MinioClient 将无法被初始化.因为没有minio所需参数");
		}
		return MinioClient.builder()
				.endpoint(properties.getEndpoint())
				.credentials(properties.getAccessKey(), properties.getSecretKey())
				.build();
	}
}

package net.balance.s3.autoconfigure;

import io.minio.MinioClient;
import net.balance.s3.properties.MinioProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Minio配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@EnableConfigurationProperties(MinioProperties.class)
@AutoConfiguration
@ComponentScan("net.balance.s3")
public class BalanceMinioAutoConfiguration {

	/**
	 * 初始化Minio 配置对象
	 */
	@Bean
	@ConditionalOnMissingBean
	public MinioProperties minioProperties(final MinioProperties properties) {
		return properties;
	}

	/**
	 * 初始化Minio 客户端
	 */
	@Bean
	@ConditionalOnMissingBean
	public MinioClient minioClient(final MinioProperties properties) {
		return MinioClient.builder()
				.endpoint(properties.getEndpoint())
				.credentials(properties.getAccessKey(), properties.getSecretKey())
				.build();
	}
}

package net.balance.autoconfigure;

import net.balance.properties.MinioProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * MiniIo配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@EnableConfigurationProperties(MinioProperties.class)
@AutoConfiguration
public class BalanceMinioAutoConfiguration {

	/**
	 * 初始化Minio 配置对象
	 */
	@Bean
	public MinioProperties minioProperties(final MinioProperties minioProperties) {
		return minioProperties;
	}
}

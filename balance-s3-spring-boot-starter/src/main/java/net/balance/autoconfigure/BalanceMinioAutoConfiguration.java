package net.balance.autoconfigure;

import net.balance.properties.MinioProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * MiniIo配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@EnableConfigurationProperties(MinioProperties.class)
@AutoConfiguration
public class BalanceMinioAutoConfiguration {

	@Bean
	public MinioProperties minioProperties(final MinioProperties minioProperties) {
		return minioProperties;
	}
}

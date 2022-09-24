package net.balance.minio.autoconfigure;

import io.minio.MinioClient;
import net.balance.common.Balance;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.minio.properties.MinioProperties;
import net.balance.s3.common.internal.MinioConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Minio自动配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@EnableConfigurationProperties(MinioProperties.class)
@AutoConfiguration
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
			logger.error("【Minio自动化配置】未检测到minio相关配置、如需使用请前去配置。若无需使用 请排除: BalanceMinioAutoConfiguration.class");
		}
		return properties;
	}

	/**
	 * 初始化Minio 客户端
	 */
	@Bean
	@ConditionalOnMissingBean
	public MinioClient minioClient(final MinioProperties properties) {

		if (null == properties || properties.isEmpty()) {
			logger.error("【Minio自动化配置】MinioClient 将无法被初始化.因为没有minio所需参数,请检查！");
		}

		final MinioClient client = MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();

		if (null != client) {
			logger.info("【Balance-Minio】: 服务启动成功！当前SDK版本:{},当前minio依赖版本{}", Balance.BALANCE_MINIO_DEV_SDK_VERSION, MinioConstants.MINIO_SDK_VERSION);
		} else {
			BalanceExceptionUtil.newBalanceException("无法初始化minioClient", BalanceCode.CodeMissingConfiguration);
		}
		return client;
	}
}

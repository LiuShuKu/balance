package net.balance.obs.autoconfigure;

import com.obs.services.Log4j2Configurator;
import com.obs.services.ObsClient;
import net.balance.obs.properties.ObsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Obs自动配置类
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@EnableConfigurationProperties(ObsProperties.class)
@AutoConfiguration
public class BalanceObsAutoConfiguration {

	private final Logger logger = LoggerFactory.getLogger(BalanceObsAutoConfiguration.class);

	/**
	 * 初始化Obs 配置对象
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public ObsProperties obsProperties(final ObsProperties properties) {
		if (properties == null || properties.isEmpty()) {
			logger.warn("【OBS自动化配置】未检测到Obs相关配置、如需使用请前去配置。若无需使用 请排除：BalanceObsAutoConfiguration.class");
		}
		return properties;
	}

	/**
	 * 初始化Obs 客户端
	 */
	@Bean
	@ConditionalOnMissingBean
	public ObsClient obsClient(final ObsProperties properties) {
		Log4j2Configurator.setLogConfig("src/main/resources/log4j2.xml");
		if (properties == null || properties.isEmpty()) {
			logger.warn("【OBS自动化配置】ObsClient 将无法被初始化.因为没有Obs所需参数");
		}
		return new ObsClient(properties.getAccessKey(), properties.getSecretKey(), properties.getEndpoint());
	}
}

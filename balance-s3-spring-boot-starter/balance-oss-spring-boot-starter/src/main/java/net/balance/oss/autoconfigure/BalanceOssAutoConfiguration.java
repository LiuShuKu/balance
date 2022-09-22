package net.balance.oss.autoconfigure;

import net.balance.oss.properties.OssProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 阿里云 OSS 自动配置
 *
 * @author : ShuLiu
 * @date : 22 : 09 : 2022/9/22
 */
@EnableConfigurationProperties(OssProperties.class)
@AutoConfiguration
public class BalanceOssAutoConfiguration {

	private final Logger logger = LoggerFactory.getLogger(BalanceOssAutoConfiguration.class);

}

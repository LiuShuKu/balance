package net.balance.oss.autoconfigure;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import net.balance.common.Balance;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.oss.properties.OssProperties;
import net.balance.s3.common.internal.OssConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

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

	/**
	 * 初始化OSS 配置对象
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean
	public OssProperties ossProperties(final OssProperties properties) {
		if (properties == null || properties.isEmpty()) {
			logger.error("【OSS自动化配置】未检测到 oss 相关配置、如需使用请前去配置。若无需使用 请排除: BalanceOssAutoConfiguration.class");
		}
		return properties;
	}

	/**
	 * 初始化OSS 客户端<br/>
	 * 用户请不要调用 ossClient 的 shutdown()方法;<br/>
	 * ossClient本身也封装了一个PoolingHttpClientConnectionManager对象,说明它本身就是支持链接池的,也就是可以并发访问;<br/>
	 * ossClient对象存储在SpringIOC容器里面为单列,并不会产生OOM;
	 */
	@Bean
	@ConditionalOnMissingBean
	public OSS ossClient(final OssProperties properties) {
		if (properties == null || properties.isEmpty()) {
			logger.error("【OSS自动化配置】OSSClient 将无法被初始化.因为没有oss所需参数,请检查！");
		}
		final ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
		{
			conf.setUserAgent("balance-oss-service");
		}

		final OSS ossClient = new OSSClientBuilder().build(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret(), conf);

		if (null != ossClient) {
			logger.info("【Balance-OSS】: 服务启动成功！当前SDK版本:{},当前oss服务依赖版本{}", Balance.BALANCE_OSS_DEV_SDK_VERSION, OssConstants.OSS_SDK_VERSION);
		}
		{
			BalanceExceptionUtil.newBalanceException("无法初始化ossClient", BalanceCode.CodeMissingConfiguration);
		}
		return ossClient;

	}
}

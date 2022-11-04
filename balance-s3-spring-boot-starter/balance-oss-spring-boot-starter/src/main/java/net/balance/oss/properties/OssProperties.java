package net.balance.oss.properties;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取阿里云Oss配置 <br>
 * <p>
 * 官方文档: <br>
 * <a href="https://help.aliyun.com/product/31815.html?spm=5176.7933691.J_5253785160.6.195e4c5908DOqc/">...</a>
 *
 * @author : ShuLiu
 * @date : 22 : 09 : 2022/9/22
 */
@Data
@ConfigurationProperties(prefix = "balance.s3.oss")
public class OssProperties {

	/**
	 * Bucket所在地域对应的Endpoint<br/>
	 * 以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
	 */
	private String endpoint;

	/**
	 * 阿里云账号AccessKey
	 */
	private String accessKeyId;

	/**
	 * 阿里云 accessKeySecret
	 */
	private String accessKeySecret;

	/**
	 * 存储桶名称(选填)
	 * <p>
	 * 若不为空则默认采用此桶
	 */
	private String bucketName;

	/**
	 * 全参构造
	 *
	 * @param endpoint        endpoint
	 * @param accessKeyId     accessKeyId
	 * @param accessKeySecret accessKeySecret
	 * @param bucketName      bucketName
	 */
	protected OssProperties(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
		this.endpoint = endpoint;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.bucketName = bucketName;
	}

	/**
	 * 无参构造
	 */
	private OssProperties() {
	}

	/**
	 * 检查对象是否为空
	 *
	 * @return null -> true; not null -> false
	 */
	public boolean isEmpty() {
		return StrUtil.hasBlank(this.accessKeyId, this.accessKeySecret, this.endpoint);
	}
}

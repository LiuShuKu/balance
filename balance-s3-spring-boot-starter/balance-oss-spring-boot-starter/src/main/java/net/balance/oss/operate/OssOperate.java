package net.balance.oss.operate;

import io.minio.messages.Bucket;
import net.balance.common.Balance;
import net.balance.s3.common.internal.OssConstants;
import net.balance.s3.common.operate.api.S3BucketApi;
import net.balance.s3.common.operate.base.AbstractS3;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 封装 阿里云Oss 常见操作
 * <p>
 * 参考:<a href="https://help.aliyun.com/document_detail/32008.html">...</a>
 *
 * @author : ShuLiu
 * @date : 23 : 09 : 2022/9/23
 */
@Component
public class OssOperate extends AbstractS3 implements S3BucketApi {

	/**
	 * 创建存储桶
	 *
	 * @param bucketName 存储桶名称
	 * @return 创建结果
	 */
	@Override
	public boolean makeBucket(String bucketName) {
		return false;
	}

	/**
	 * 检查存储桶是否存在
	 *
	 * @param bucketName 存储桶名称
	 * @return true 存在 ; false 不存在
	 */
	@Override
	public boolean bucketExists(String bucketName) {
		return false;
	}

	/**
	 * 列出所有存储桶
	 *
	 * @return 存储桶列表 @see{List Bucket}
	 */
	@Override
	public List<Bucket> listBuckets() {
		return null;
	}

	/**
	 * 删除存储桶
	 * <p>
	 * 注意，只有存储桶为空时才能删除成功
	 *
	 * @param bucketName 存储桶名称
	 * @return true 删除成功 ; false 删除失败
	 */
	@Override
	public boolean removeBucket(String bucketName) {
		return false;
	}

	/**
	 * 当前服务引用官方SDK版本
	 *
	 * @return 官方SDK版本
	 */
	@Override
	public String currentApplicationSDKVersion() {
		return OssConstants.OSS_SDK_VERSION;
	}

	/**
	 * 当前工程版本
	 *
	 * @return 当前Balance-SDK版本
	 */
	@Override
	public String currentBalanceSDKVersion() {
		return Balance.BALANCE_OSS_DEV_SDK_VERSION;
	}
}

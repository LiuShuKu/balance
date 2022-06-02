package net.balance.s3.operate;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import net.balance.common.system.error.base.AssertBalanceException;
import net.balance.common.system.model.BalanceCode;
import net.balance.s3.model.BalanceBucket;
import net.balance.s3.operate.api.S3BucketApi;
import net.balance.s3.operate.base.AbstractS3;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 封装Minio常见操作
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class MinioOperate extends AbstractS3 implements S3BucketApi {

	@Resource
	private MinioClient client;

	/**
	 * 获取当前工具版本
	 *
	 * @return 当前应用使用的Maven依赖版本
	 */
	@Override
	public String currentToolVersion() {
		return null;
	}

	/**
	 * 获取当前版本
	 *
	 * @return Minio版本
	 */
	@Override
	public String currentVersion() {
		return null;
	}

	//----------------------- bucket
	// Doc: https://docs.min.io/docs/java-client-api-reference.html#bucketExists

	/**
	 * 创建存储桶
	 *
	 * @param bucketName 存储桶名称
	 * @return 创建结果
	 */
	@Override
	public boolean makeBucket(String bucketName) {
		MakeBucketArgs param = MakeBucketArgs.builder().bucket(bucketName).build();

		try {
			client.makeBucket(param);
		} catch (Exception e) {
			AssertBalanceException.balanceException(true, BalanceCode.CodeOperationFailed);
			return false;
		}
		return true;
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
	 * @return 存储桶列表 @see{List BalanceBucket}
	 */
	@Override
	public List<BalanceBucket> listBuckets() {
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
}

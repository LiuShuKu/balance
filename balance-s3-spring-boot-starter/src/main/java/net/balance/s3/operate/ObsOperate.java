package net.balance.s3.operate;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.AvailableZoneEnum;
import com.obs.services.model.CreateBucketRequest;
import com.obs.services.model.StorageClassEnum;
import io.minio.messages.Bucket;
import net.balance.common.system.error.Either;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.s3.operate.api.S3BucketApi;
import net.balance.s3.operate.base.AbstractS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 封装 华为云Obs 常见操作
 * <p>
 * 参考:https://support.huaweicloud.com/obs/index.html
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class ObsOperate extends AbstractS3 implements S3BucketApi {

	@Autowired(required = false)
	private ObsClient obsClient;


	/**
	 * 获取当前工具版本
	 *
	 * @return 当前应用使用的依赖版本
	 */
	@Override
	public String currentToolVersion() {
		return null;
	}

	/**
	 * 获取当前版本
	 *
	 * @return 当前Obs当前版本
	 */
	@Override
	public String currentVersion() {
		return null;
	}


	// ---------------------------- 桶操作

	/**
	 * 创建存储桶
	 *
	 * @param bucketName 存储桶名称
	 * @return 创建结果
	 */
	@Override
	public boolean makeBucket(final String bucketName) {
		final Either either = Either.warpBalanceSupplier(() -> {
			// 	cn-north-4

			CreateBucketRequest request = new CreateBucketRequest();
			request.setBucketName(bucketName);
// 设置桶访问权限为公共读，默认是私有读写
			request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
// 设置桶的存储类型为归档存储
			request.setBucketStorageClass(StorageClassEnum.COLD);
// 设置桶区域位置
			request.setLocation("cn-north-4");
// 指定创建多AZ桶，如果不设置，默认创建单AZ桶
			request.setAvailableZone(AvailableZoneEnum.MULTI_AZ);
			obsClient.createBucket(request);
			return null;
		});

		if (either.exceptionIsNotEmpty()) {
			ObsException e = (ObsException) either.getException().get();
			System.out.println("HTTP Code: " + e.getResponseCode());
			System.out.println("Error Code:" + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());

			System.out.println("Request ID:" + e.getErrorRequestId());
			System.out.println("Host ID:" + e.getErrorHostId());
			BalanceExceptionUtil.newBalanceException((Exception) either.getException().get(), BalanceCode.CodeInternalError);
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
}

package net.balance.s3.operate;

import com.obs.services.internal.Constants;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import io.minio.messages.Bucket;
import net.balance.common.system.error.Either;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.s3.operate.api.S3BucketApi;
import net.balance.s3.operate.api.S3ObjectApi;
import net.balance.s3.operate.base.AbstractS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 封装Minio常见操作
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class MinioOperate extends AbstractS3 implements S3BucketApi, S3ObjectApi {

	@Autowired(required = false)
	private MinioClient minioClient;


	/**
	 * 获取当前工具版本
	 *
	 * @return 当前应用使用的Maven依赖版本
	 */
	@Override
	public String currentToolVersion() {
		return Constants.OBS_SDK_VERSION;
	}

	/**
	 * 获取当前版本
	 *
	 * @return Obs版本
	 */
	@Override
	public String currentVersion() {
		return Constants.OBS_SDK_VERSION;
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
	public boolean makeBucket(final String bucketName) {
		final MakeBucketArgs args = MakeBucketArgs.builder().bucket(bucketName).build();

		final Either either = Either.warpBalanceSupplier(() -> {
			minioClient.makeBucket(args);
			return null;
		});

		if (either.exceptionIsNotEmpty()) {
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
	public boolean bucketExists(final String bucketName) {
		final BucketExistsArgs args = BucketExistsArgs.builder().bucket(bucketName).build();

		final Either either = Either.warpBalanceSupplier(() -> {
			return minioClient.bucketExists(args);
		});

		if (either.exceptionIsNotEmpty()) {
			BalanceExceptionUtil.newBalanceException((Exception) either.getException().get(), BalanceCode.CodeInternalError);
		}
		return (boolean) either.getValue().get();
	}

	/**
	 * 列出所有存储桶
	 *
	 * @return 存储桶列表 @see{List Bucket}
	 */
	@Override
	public List<Bucket> listBuckets() {

		final Either either = Either.warpBalanceSupplier(() -> {
			return minioClient.listBuckets();
		});

		if (either.exceptionIsNotEmpty()) {
			BalanceExceptionUtil.newBalanceException((Exception) either.getException().get(), BalanceCode.CodeInternalError);
		}

		return (List<Bucket>) either.getValue().get();
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
	public boolean removeBucket(final String bucketName) {
		final RemoveBucketArgs args = RemoveBucketArgs.builder().bucket(bucketName).build();

		final Either either = Either.warpBalanceSupplier(() -> {
			minioClient.removeBucket(args);
			return null;
		});

		if (either.exceptionIsNotEmpty()) {
			BalanceExceptionUtil.newBalanceException((Exception) either.getException().get(), BalanceCode.CodeInternalError);
		}

		return true;
	}

	/**
	 * 执行文件上传
	 *
	 * @param inputStream 文件输入流
	 * @return 地址路径
	 */
	@Override
	public String putObject(final InputStream inputStream) {

		return null;
	}
}

package net.balance.s3.client;


import io.minio.MinioClient;
import io.minio.SetObjectLockConfigurationArgs;
import io.minio.messages.ObjectLockConfiguration;
import io.minio.messages.RetentionDurationDays;
import io.minio.messages.RetentionMode;
import net.balance.common.system.error.Either;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.s3.operate.MinioOperate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Minio 常用工具类
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class MinioUtil extends MinioOperate {

	final Logger logger = LoggerFactory.getLogger(MinioUtil.class);

	@Autowired(required = false)
	private MinioClient minioClient;

	/**
	 * 设置存储桶内对象保留时间
	 *
	 * @param days       保留天数
	 * @param bucketName 桶名称
	 */
	public void setObjectLockConfiguration(int days, String bucketName) {
		Either either = Either.warpBalanceSupplier(() -> {
			final ObjectLockConfiguration config = new ObjectLockConfiguration(RetentionMode.COMPLIANCE, new RetentionDurationDays(days));
			final SetObjectLockConfigurationArgs param = SetObjectLockConfigurationArgs.builder().bucket(bucketName).config(config).build();
			minioClient.setObjectLockConfiguration(param);
			return null;
		});

		if (either.exceptionIsNotEmpty()) {
			BalanceExceptionUtil.newBalanceException((Exception) either.getException().get(), BalanceCode.CodeInternalError);
		}
	}
}

package net.balance.s3.operate;

import net.balance.s3.operate.base.BaseS3;
import org.springframework.stereotype.Component;

/**
 * 封装Minio常见操作
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class MinioOperate extends BaseS3 {


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
}

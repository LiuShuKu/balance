package net.balance.s3.common.operate.base;

/**
 * 定义相关通用函数
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public abstract class AbstractS3 {

	/**
	 * 当前服务引用官方SDK版本
	 *
	 * @return 官方SDK版本
	 */
	public abstract String currentApplicationSDKVersion();

	/**
	 * 当前工程版本
	 *
	 * @return 当前Balance-SDK版本
	 */
	public abstract String currentBalanceSDKVersion();
}


package net.balance.s3.operate.base;

/**
 * 定义相关通用函数
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public abstract class BaseS3 {

	/**
	 * 获取当前工具版本
	 *
	 * @return 当前应用使用的Maven依赖版本
	 */
	public abstract String currentToolVersion();

	/**
	 * 获取当前版本
	 *
	 * @return 当前存储产品版本
	 */
	public abstract String currentVersion();
}


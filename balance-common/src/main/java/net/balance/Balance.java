package net.balance.common;

/**
 * 星光不问赶路人,时光不负有心人。
 * 永远学习 、 永远热泪盈眶 。
 * <p>
 * Balance 是一款SpringBoot业务快速开发工具包。通过封装常见三方组件,降低相关API的学习成本，提高工作效率。
 * 工程结构分包明确,少量lambda语法,让人人都可以看得明确用的便捷。
 * <p>
 * Balance 是项目开发中 基础Web侧解构体、三方服务商接口 的友好代替 它节省了开发人员对项目中公用类和公用工具方法的封装时间.
 * 使开发专注于业务，同时可以最大限度的避免因每个人能力不同、代码的命名、项目迭代、版本迭代、需要多人维护等原因不完善带来的bug.
 * google、baidu 上的解答可能各有不一、或者版本无法对应等问题、无从选择一个真正适合的配置文件，Balance帮你解决。
 * <p>
 * Balance 灵感来自于 Hutool 一个小而全的Java工具类库 和 复盘工作中团队管理协作日积月累出现问题的想法。
 *
 * @author : ShuLiu
 * @date : 2022.1.1
 */
public interface Balance {

	/**
	 * 邮箱: liushuku@yeah.net
	 */
	String AUTHOR = "LiuShuKu";

	/**
	 * 当前工程版本
	 */
	String VERSION = "1.0.0";

	// ----------------- 对象存储服务

	/**
	 * 华为云 OBS 版本
	 */
	String BALANCE_OBS_DEV_SDK_VERSION = "1.0.0";

	/**
	 * 阿里云 OSS 版本
	 */
	String BALANCE_OSS_DEV_SDK_VERSION = "1.0.0";

	/**
	 * MINIO 版本
	 */
	String BALANCE_MINIO_DEV_SDK_VERSION = "1.0.0";

}

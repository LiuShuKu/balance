package net.balance.push.getui.consts;

/**
 * 个推常量
 *
 * @author : ShuLiu
 * @date : 04 : 07 : 2022/7/4
 */
public interface GeTuiConst {

	/**
	 * 请求设置
	 */
	String CONTENT_TYPE = "application/json;charset=utf-8";

	/**
	 * 缓存中个推Token的键名
	 */
	String BALANCE_GETUI_TOKEN_PREFIX = "balanceGetuiTokenPrefix:";

	/**
	 * 个推TOKEN 有效期3小时
	 */
	long GETUI_TOKEN_TIME_OUT = 3 * 1000 * 60 * 60;

	/**
	 * 个推TOKEN 最长有效期
	 */
	long GETUI_TOKEN_MAX_TIME_OUT = 23 * 1000 * 60 * 60;
}

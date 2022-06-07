package net.balance.common.system.error.base;

import net.balance.common.system.model.BalanceCode;

/**
 * 系统自定义异常 工具类
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public class BalanceExceptionUtil {

	/**
	 * 抛出BalanceException
	 *
	 * @throws BalanceException
	 */
	public static void newBalanceException() throws BalanceException {
		throw new BalanceException();
	}

	/**
	 * 抛出BalanceException
	 *
	 * @param errMsg 错误消息
	 * @throws BalanceException
	 */
	public static void newBalanceException(final String errMsg) throws BalanceException {
		throw new BalanceException(errMsg);
	}

	/**
	 * 抛出BalanceException
	 *
	 * @param balanceCode 数据载体
	 * @throws BalanceException
	 */
	public static void newBalanceException(final BalanceCode balanceCode) throws BalanceException {
		throw new BalanceException(balanceCode);
	}

	/**
	 * 抛出BalanceException
	 *
	 * @param errMsg      错误消息
	 * @param balanceCode 数据载体
	 * @throws BalanceException
	 */
	public static void newBalanceException(final String errMsg, final BalanceCode balanceCode) throws BalanceException {
		throw new BalanceException(balanceCode, errMsg);
	}

	/**
	 * 抛出BalanceException
	 *
	 * @param exception 异常信息
	 * @throws BalanceException
	 */
	public static void newBalanceException(final Exception exception) throws BalanceException {
		BalanceCode error = BalanceCode.CodeInternalError;
		throw new BalanceException();
	}


	/**
	 * 断言成功将抛出 BalanceException
	 *
	 * @param assertion 断言条件
	 * @throws BalanceException
	 */
	public static void balanceException(final boolean assertion) throws BalanceException {
		if (assertion) {
			throw new BalanceException();
		}
	}

	/**
	 * 断言成功将抛出 BalanceException
	 *
	 * @param assertion 断言条件
	 * @param errMsg    响应消息
	 * @throws BalanceException
	 */
	public static void balanceException(final boolean assertion, final String errMsg) throws BalanceException {
		if (assertion) {
			throw new BalanceException(errMsg);
		}
	}

	/**
	 * 断言成功将抛出 BalanceException
	 *
	 * @param assertion   断言条件
	 * @param balanceCode 响应数据载体
	 * @throws BalanceException
	 */
	public static void balanceException(final boolean assertion, final BalanceCode balanceCode) throws BalanceException {
		if (assertion) {
			throw new BalanceException(balanceCode);
		}
	}

	/**
	 * 断言成功将抛出 BalanceException
	 *
	 * @param assertion   断言条件
	 * @param errMsg      响应消息
	 * @param balanceCode 响应数据载体
	 * @throws BalanceException
	 */
	public static void balanceException(final boolean assertion, final String errMsg, final BalanceCode balanceCode) throws BalanceException {
		if (assertion) {
			throw new BalanceException(balanceCode, errMsg);
		}
	}
}

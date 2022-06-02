package net.balance.common.system.error.base;

import net.balance.common.system.model.BalanceCode;

/**
 * 异常断言类
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public class AssertBalanceException {

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

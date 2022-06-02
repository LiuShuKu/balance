package net.balance.common.system.error.base;

import net.balance.common.system.model.BalanceCode;

/**
 * 定义项目异常服务
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public class BalanceException extends RuntimeException {
	private static final long serialVersionUID = 35034225777994364L;

	/**
	 * 定义数据载体
	 */
	private BalanceCode balanceCode;

	/**
	 * 向异常中设置错误信息
	 *
	 * @param errMsg 错误信息内容
	 */
	protected BalanceException(final String errMsg) {
		super(errMsg);
	}

	/**
	 * 初始化 异常
	 */
	protected BalanceException() {
		super();
	}

	/**
	 * 向异常中设置载体
	 *
	 * @param balanceCode 载体内容
	 */
	protected BalanceException(final BalanceCode balanceCode) {
		super();
		this.balanceCode = balanceCode;
	}

	/**
	 * 向异常中 设置数据载体和错误信息
	 *
	 * @param balanceCode 数据载体
	 * @param errMsg      错误信息
	 */
	protected BalanceException(final BalanceCode balanceCode, final String errMsg) {
		super(errMsg);
		this.balanceCode = balanceCode;
	}

	/**
	 * 获取数据载体
	 *
	 * @return
	 */
	public BalanceCode errorDetail() {
		return this.balanceCode;
	}

	/**
	 * 检查是否存数据载体
	 *
	 * @return
	 */
	public boolean isNotEmpty() {
		return this.balanceCode != null;
	}
}

package net.balance.common.system.error.business;

/**
 * 拓展 lang 包中 Runnable函数、抛出异常
 *
 * @author : liushuku
 * @date : 06 : 06 : 2022/6/6
 */
@FunctionalInterface
public interface BalanceRunnable {
	/**
	 * 无参 无返回值 抛出异常
	 *
	 * @throws Exception
	 */
	void run() throws Exception;
}

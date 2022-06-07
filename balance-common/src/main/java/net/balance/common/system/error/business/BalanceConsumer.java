package net.balance.common.system.error.business;

/**
 * 拓展 lang 包中 Consumer函数、抛出异常
 *
 * @author : liushuku
 * @date : 06 : 06 : 2022/6/6
 */
@FunctionalInterface
public interface BalanceConsumer<T> {

	/**
	 * 执行函数 并抛出异常
	 *
	 * @param t 泛型参数
	 * @throws Exception
	 */
	void accept(T t) throws Exception;
}

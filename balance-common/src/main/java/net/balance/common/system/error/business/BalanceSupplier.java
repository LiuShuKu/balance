package net.balance.common.system.error.business;

/**
 * 拓展 lang 包中 Supplier函数、抛出异常
 *
 * @author : liushuku
 * @date : 06 : 06 : 2022/6/6
 */
@FunctionalInterface
public interface BalanceSupplier<T> {

	/**
	 * 无参返回数据
	 *
	 * @return 泛型数据
	 * @throws Exception
	 */
	T get() throws Exception;
}

package net.balance.common.system.error.business;

/**
 * @author : liushuku
 * @date : 01 : 06 : 2022/6/1
 */

@FunctionalInterface
public interface BalanceError<T, R> {

	/**
	 * 处理数据内容
	 *
	 * @param t
	 * @return
	 * @throws Exception
	 */
	R apply(T t) throws Exception;
}

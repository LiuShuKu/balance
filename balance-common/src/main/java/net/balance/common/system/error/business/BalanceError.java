package net.balance.common.system.error.business;

/**
 * @author : liushuku
 * @date : 01 : 06 : 2022/6/1
 */
@FunctionalInterface
public interface BalanceError<T> {

	void apply(T t) throws Exception;
}

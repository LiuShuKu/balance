package net.balance.common.system.error;

import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.error.business.BalanceRunnable;
import net.balance.common.system.error.business.BalanceSupplier;
import net.balance.common.system.model.BalanceCode;

import java.util.Optional;
import java.util.function.Function;

/**
 * 通过lambda 包装异常
 * <p>
 * 核心：<br>
 * 1. 封装lang包下的部分函数式接口、全部增加 throw Exception <br>
 * 2. 将会抛出异常的函数、通过闭包的方式传入、内部进行捕捉<br>
 * 3. Golang语言思想 error is value<br>
 *
 * @author : liushuku
 * @date : 02 : 06 : 2022/6/2
 */
public class Either<E, V> {

	/**
	 * 异常
	 */
	private final E exception;

	/**
	 * 数据
	 */
	private final V value;


	/**
	 * 初始化
	 *
	 * @param exception 异常
	 * @param value     数据
	 */
	private Either(E exception, V value) {
		this.exception = exception;
		this.value = value;
	}

	/**
	 * 初始一个空 Either
	 */
	private Either() {
		this.exception = null;
		this.value = null;
	}

	@Override
	public String toString() {
		return "Either{" +
				"exception=" + exception +
				", value=" + value +
				'}';
	}

	/**
	 * 设置异常
	 *
	 * @param exception 异常值
	 * @return 携带exception 的 Either
	 */
	public static <E, V> Either<E, V> exception(E exception) {
		return new Either(exception, null);
	}

	/**
	 * 设置数据
	 *
	 * @param value 数据内容
	 * @return 携带value 的 Either
	 */
	public static <E, V> Either<E, V> value(V value) {
		return new Either(null, value);
	}


	/**
	 * 获取异常
	 *
	 * @return
	 */
	public Optional<E> getException() {
		return Optional.ofNullable(exception);
	}


	/**
	 * 获取数据
	 *
	 * @return
	 */
	public Optional<V> getValue() {
		return Optional.ofNullable(value);
	}

	/**
	 * 检查异常是否不为空
	 *
	 * @return
	 */
	public boolean exceptionIsNotEmpty() {
		return exception != null;
	}

	/**
	 * 检查数据是否不为空
	 *
	 * @return
	 */
	public boolean valueIsNotEmpty() {
		return value != null;
	}

	/**
	 * 处理异常
	 *
	 * @param mapper
	 * @param <T>
	 * @return
	 */
	public <T> Optional<T> mapException(Function<? super E, T> mapper) {
		if (exceptionIsNotEmpty()) {
			return Optional.of(mapper.apply(exception));
		}
		return Optional.empty();
	}

	/**
	 * 处理数据
	 *
	 * @param mapper
	 * @param <T>
	 * @return
	 */
	public <T> Optional<T> mapValue(Function<? super V, T> mapper) {
		if (valueIsNotEmpty()) {
			return Optional.of(mapper.apply(value));
		}
		return Optional.empty();
	}
	// ------------------- 有参有返回值函数 处理
	// ------------------- 有参无返回值函数 处理


	// ------------------- 无参有返回值函数 处理

	/**
	 * 若发生异常、Either 的 exception 将不为空;
	 * <p>
	 * 若函数体执行成功、则 Either 的Value 将不为空;
	 *
	 * @param fun
	 * @param <E>
	 * @param <V>
	 * @return
	 */
	public static <E, V> Either warpBalanceSupplier(BalanceSupplier fun) {
		try {
			return Either.value(fun.get());
		} catch (Exception e) {
			return Either.exception(e);
		}
	}

	/**
	 * 若发生异常、将以 RuntimeException方式抛出
	 * <p>
	 * 若函数体执行成功、则 Either 的Value 将不为空;
	 *
	 * @param fun
	 * @param <E>
	 * @param <V>
	 * @return
	 */
	public static <E, V> Either warpBalanceSupplierThrowException(BalanceSupplier fun) {
		try {
			return Either.value(fun.get());
		} catch (Exception e) {
			BalanceExceptionUtil.newBalanceException(BalanceCode.CodeInternalError);
		}
		return new Either();
	}

	// ------------------- 无参无返回值函数 处理

	/**
	 * 将异常数据作为 RuntimeException方式抛出
	 *
	 * @param fun无参无返回值的函数
	 */
	public static void warpBalanceRunnable(BalanceRunnable fun) {
		try {
			fun.run();
		} catch (Exception e) {
			BalanceExceptionUtil.newBalanceException(BalanceCode.CodeInternalError);
		}
	}

	/**
	 * 将异常数据作为 结果方式返回
	 * <p>
	 *
	 * @param fun无参无返回值的函数
	 * @return Either实体
	 */
	public static Either warpBalanceRunnableThrowException(BalanceRunnable fun) {
		try {
			fun.run();
		} catch (Exception e) {
			return Either.exception(e);
		}
		return new Either();
	}
}

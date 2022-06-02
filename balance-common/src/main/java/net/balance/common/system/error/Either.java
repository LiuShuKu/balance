package net.balance.common.system.error;

import java.util.Optional;
import java.util.function.Function;

/**
 * 包装 lambda 异常
 * <p>
 * E: exception
 * <p>
 * V: value
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
	 * @param exception
	 * @param value
	 */
	private Either(E exception, V value) {
		this.exception = exception;
		this.value = value;
	}


	/**
	 * 设置异常
	 *
	 * @param exception
	 * @param <E>
	 * @param <V>
	 * @return
	 */
	public static <E, V> Either<E, V> exception(E exception) {
		return new Either(exception, null);
	}

	/**
	 * 设置数据
	 *
	 * @param value
	 * @param <E>
	 * @param <V>
	 * @return
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

	//*---------------------- 工具

	/**
	 * lamber 抛出异常
	 * 发生异常时,流的处理会立即停止
	 *
	 * @param function
	 * @param <T>
	 * @param <R>
	 * @return
	 */
//	public static <T, R> Function<T, R> warp(BalanceError<T, R> function) {
//		return t -> {
//			try {
//				return function.apply(t);
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
//		};
//	}
//
//
//	/**
//	 * lamber 抛出异常
//	 * 发生异常时,流的处理会继续
//	 * 不保存原始值
//	 *
//	 * @param function
//	 * @param <T>
//	 * @param <R>
//	 * @return
//	 */
//	public static <T, R> Function<T, Either> lift(BalanceError<T, R> function) {
//		return t -> {
//			try {
//				return Either.value(function.apply(t));
//			} catch (Exception e) {
//				return Either.exception(e);
//			}
//		};
//	}
//
//
//	/**
//	 * lamber 抛出异常
//	 * 发生异常时,流的处理会继续
//	 * 异常和原始值都保存在左侧
//	 *
//	 * @param function
//	 * @param <T>
//	 * @param <R>
//	 * @return
//	 */
//	public static <T, R> Function<T, Either> liftWithValue(BalanceError<T, R> function) {
//		return t -> {
//			try {
//				return Either.value(function.apply(t));
//			} catch (Exception ex) {
//				return Either.exception(Pair.of(ex, t));
//			}
//		};
//	}
}

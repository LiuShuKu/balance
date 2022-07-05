package net.balance.common.system.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 *
 * @author : ShuLiu
 * @date : 05 : 07 : 2022/7/5
 */
@Component
public class BalanceRedisUtil {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 设置一个 键值对缓存
	 *
	 * @param key   字符串类型
	 * @param value Object类型
	 */
	public final void set(final String key, Object value) {
		redisTemplate.boundValueOps(key).set(value);
	}

	/**
	 * 设置一个 键值对缓存
	 *
	 * @param key   字符串类型
	 * @param value Object类型
	 */
	public final void setOffset(String key, Object value, long offset) {
		redisTemplate.boundValueOps(key).set(value, offset);
	}

	/**
	 * 设置一个缓存
	 *
	 * @param key     键
	 * @param value   值
	 * @param timeout 过期时间 默认单位毫秒
	 */
	public final void set(final String key, Object value, Long timeout) {
		redisTemplate.boundValueOps(key).set(value, timeout, TimeUnit.MILLISECONDS);
	}

	/**
	 * 设置一个缓存
	 *
	 * @param key     键
	 * @param value   值
	 * @param timeout 过期时间 默认单位毫秒
	 */
	public final void set(final String key, Object value, Long timeout, TimeUnit unit) {
		redisTemplate.boundValueOps(key).set(value, timeout, unit);
	}


	/**
	 * 检查key是否存在
	 *
	 * @param key 键
	 * @return 存在返回 true
	 */
	public final Boolean hashKey(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 删除一个key
	 *
	 * @param key 键
	 * @return 成功返回 true
	 */
	public final Boolean delete(final String key) {
		return redisTemplate.delete(key);
	}

	/**
	 * 删除一组key
	 *
	 * @param keys 键集合
	 */
	public final void deleteKeys(Collection<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 设置key 过期时间
	 * 默认单位毫秒
	 *
	 * @param key     键
	 * @param timeout 过期时间
	 */
	public final void expire(String key, Long timeout) {
		redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
	}

	/**
	 * 获取key过期时间
	 * 单位毫秒
	 *
	 * @param key 键
	 * @return 剩余过期时间
	 */
	public final Long getExpire(String key) {
		return redisTemplate.getExpire(key);
	}

	/**
	 * 将key内容 增加1
	 *
	 * @param key 键
	 */
	public final void cacheIncrement(final String key) {
		redisTemplate.boundValueOps(key).increment(1L);
	}

	/**
	 * 将key内容 增加number
	 *
	 * @param key    键
	 * @param number 增加的数值
	 */
	public final void cacheIncrement(final String key, Long number) {
		redisTemplate.boundValueOps(key).increment(number);
	}

	/**
	 * 将key内容 减少number
	 *
	 * @param key    键
	 * @param number 减少的数值
	 */
	public final void cacheDecrement(final String key, Long number) {
		redisTemplate.boundValueOps(key).increment(-number);
	}


	/**
	 * 将key内容 减1
	 *
	 * @param key 键
	 */
	public final void cacheDecrement(final String key) {
		redisTemplate.boundValueOps(key).increment(-1L);
	}

	/**
	 * 获取key对应的值
	 *
	 * @param key 键
	 * @return 值
	 */
	public final Object get(final String key) {
		return redisTemplate.boundValueOps(key).get();
	}
}

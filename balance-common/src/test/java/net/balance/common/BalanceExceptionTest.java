package net.balance.common;

import cn.hutool.core.lang.Console;
import net.balance.common.system.error.base.BalanceException;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import org.junit.Test;


/**
 * 单元测试
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public class BalanceExceptionTest {


	@Test
	public void TestBalanceException1() {

		//  模拟发生BalanceException
		try {
			BalanceExceptionUtil.balanceException(true);
		} catch (BalanceException exception) {
			Console.log("当前异常是否存在载体:{}", exception.isNotEmpty());
		}
	}


	@Test
	public void TestBalanceException2() {
		// 模拟发生BalanceException
		try {
			BalanceExceptionUtil.balanceException(true, BalanceCode.CodeInternalError);
		} catch (BalanceException exception) {
			Console.log("当前异常是否存在载体:{}", exception.isNotEmpty());
			Console.log("载体为:{}", exception.errorDetail());
			Console.log("载体code为:{}", exception.errorDetail().code());
		}
	}
}

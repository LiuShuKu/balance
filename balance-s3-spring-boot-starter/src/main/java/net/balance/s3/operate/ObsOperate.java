package net.balance.s3.operate;

import net.balance.s3.operate.base.AbstractS3;
import org.springframework.stereotype.Component;

/**
 * 封装 华为云Obs 常见操作
 * <p>
 * 参考:https://support.huaweicloud.com/obs/index.html
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class ObsOperate extends AbstractS3 {


	/**
	 * 获取当前工具版本
	 *
	 * @return 当前应用使用的依赖版本
	 */
	@Override
	public String currentToolVersion() {
		return null;
	}

	/**
	 * 获取当前版本
	 *
	 * @return 当前Obs当前版本
	 */
	@Override
	public String currentVersion() {
		return null;
	}

}

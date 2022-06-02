package net.balance.s3.client;


import net.balance.s3.operate.MinioOperate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Minio 常用工具类
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Component
public class MinioUtil extends MinioOperate {

	@Resource
	private MinioOperate minioOperate;

	public void make() {
	}

}

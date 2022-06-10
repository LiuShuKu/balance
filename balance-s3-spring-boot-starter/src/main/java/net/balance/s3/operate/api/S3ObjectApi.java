package net.balance.s3.operate.api;

import java.io.InputStream;

/**
 * 对象操作
 *
 * @author : liushuku
 * @date : 09 : 06 : 2022/6/9
 */
public interface S3ObjectApi {

	/**
	 * 执行文件上传
	 *
	 * @param inputStream 文件输入流
	 * @return 地址路径
	 */
	String putObject(final InputStream inputStream);
}

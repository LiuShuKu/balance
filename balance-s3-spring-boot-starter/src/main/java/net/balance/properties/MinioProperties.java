package net.balance.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取minio配置
 *
 * @author : liushuku
 * @date : 30 : 05 : 2022/5/30
 */
@Component
@ConfigurationProperties(prefix = "balance.s3.minio")
public class MinioProperties {

	private String url ;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNum() {
		return num;
	}

	/**
	 * 配置数量
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	private int num;

	@Override
	public String toString() {
		return "MinioProperties{" +
				"url='" + url + '\'' +
				", num=" + num +
				'}';
	}

	public MinioProperties(String url, int num) {
		this.url = url;
		this.num = num;
	}

	public MinioProperties() {
	}

}

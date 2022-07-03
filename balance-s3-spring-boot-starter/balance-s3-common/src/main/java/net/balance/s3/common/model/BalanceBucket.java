package net.balance.s3.common.model;

import lombok.Data;

/**
 * 存储桶实体
 *
 * @author : liushuku
 * @date : 01 : 06 : 2022/6/1
 */
@Data
public class BalanceBucket {

	/**
	 * 桶名称
	 */
	private String bucketName;


	/**
	 * 创建时间
	 * 时间戳
	 */
	private String created;

	public BalanceBucket(String bucketName, String created) {
		this.bucketName = bucketName;
		this.created = created;
	}

	public BalanceBucket() {
	}


}

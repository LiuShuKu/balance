package net.balance.s3.common.operate.api;

import io.minio.messages.Bucket;

import java.util.List;

/**
 * 文件桶操作
 *
 * @author : liushuku
 * @date : 01 : 06 : 2022/6/1
 */
public interface S3BucketApi {

	/**
	 * 创建存储桶
	 *
	 * @param bucketName 存储桶名称
	 * @return 创建结果
	 */
	boolean makeBucket(final String bucketName);

	/**
	 * 检查存储桶是否存在
	 *
	 * @param bucketName 存储桶名称
	 * @return true 存在 ; false 不存在
	 */
	boolean bucketExists(final String bucketName);

	/**
	 * 列出所有存储桶
	 *
	 * @return 存储桶列表 @see{List Bucket}
	 */
	List<Bucket> listBuckets();

	/**
	 * 删除存储桶
	 * <p>
	 * 注意，只有存储桶为空时才能删除成功
	 *
	 * @param bucketName 存储桶名称
	 * @return true 删除成功 ; false 删除失败
	 */
	boolean removeBucket(final String bucketName);


}

/**
 * @文件名称：StackStroagePoolFactory.java
 * @类路径：com.qqw.fileserver.pools
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 31, 20122:14:16 PM
 */
package com.qqw.fileserver.pools;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.StackObjectPoolFactory;
import org.csource.fastdfs.StorageClient1;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 31, 20122:14:16 PM
 */
public class StackStroagePoolFactory {
	private  StackObjectPoolFactory<StorageClient1> stackObjectPoolFactory;

	public void init() {
		PoolableStorageClient poolableStorageClient = new PoolableStorageClient();
		stackObjectPoolFactory = new StackObjectPoolFactory<StorageClient1>(
				poolableStorageClient, 3, 5);
	}

	public  ObjectPool<StorageClient1> createPool() {
		return stackObjectPoolFactory.createPool();
	}

	public  StorageClient1 getFastDfsStorageClient() throws Exception {
		return stackObjectPoolFactory.createPool().borrowObject();
	}

	public  void returnFastDfsStorageClient(StorageClient1 storageClient1)
			throws Exception {
		stackObjectPoolFactory.createPool().returnObject(storageClient1);
	}
}

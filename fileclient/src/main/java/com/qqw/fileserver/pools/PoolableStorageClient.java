/**
 * @文件名称：StorageClientPool.java
 * @类路径：com.qqw.fileserver.pools
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 31, 20121:05:51 PM
 */
package com.qqw.fileserver.pools;

import org.apache.commons.pool.PoolableObjectFactory;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 31, 20121:05:51 PM
 */
public class PoolableStorageClient implements PoolableObjectFactory<StorageClient1>{
	/* (non-Javadoc)
	 * @see org.apache.commons.pool.PoolableObjectFactory#makeObject()
	 */
	public StorageClient1 makeObject() throws Exception {
		String config = "fastdfs.properties";
		ClientGlobal.init(config);
		TrackerGroup trackerGroup = ClientGlobal.getG_tracker_group();
		TrackerClient tracker = new TrackerClient(trackerGroup);
  		TrackerServer trackerServer = tracker.getConnection();
  		StorageServer storageServer = tracker.getStoreStorage(trackerServer);
  		StorageClient1 client = new StorageClient1(trackerServer, storageServer);
  	
		return client;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool.PoolableObjectFactory#destroyObject(java.lang.Object)
	 */
	public void destroyObject(StorageClient1 client) throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool.PoolableObjectFactory#validateObject(java.lang.Object)
	 */
	public boolean validateObject(StorageClient1 client) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool.PoolableObjectFactory#activateObject(java.lang.Object)
	 */
	public void activateObject(StorageClient1 client) throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool.PoolableObjectFactory#passivateObject(java.lang.Object)
	 */
	public void passivateObject(StorageClient1 client) throws Exception {
		
	}

}

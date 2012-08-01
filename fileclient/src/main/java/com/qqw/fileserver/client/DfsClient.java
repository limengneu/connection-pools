/**
 * @文件名称：DfsServiceImpl.java
 * @类路径：com.qqw.fileserver.impl
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 30, 20124:14:13 PM
 */
package com.qqw.fileserver.client;

import java.io.InputStream;

import org.csource.fastdfs.StorageClient1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qqw.fileserver.exception.FileServerException;
import com.qqw.fileserver.pools.StackStroagePoolFactory;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 30, 20124:14:13 PM
 */
public class DfsClient {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private StackStroagePoolFactory stackStroagePoolFactory;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qqw.fileserver.DfsService#saveFile(java.io.File)
	 */
	public String saveFile(String localFileName) throws FileServerException {
		StorageClient1 storageClient1 = null;
		String fastDFSFileId = null;
		try {
			storageClient1 = stackStroagePoolFactory.getFastDfsStorageClient();
		} catch (Exception e) {
			logger.error(e.getMessage()+" saveFile localFileName fastdfs pools is wrong", e);
			throw new FileServerException(e);
		}
		try {
			fastDFSFileId = storageClient1.upload_file1(localFileName, null,
					null);
		} catch (Exception e) {
			logger.error(e.getMessage()+" fastdfs upload file is wrong", e);
			throw new FileServerException(e);
		}

		return fastDFSFileId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qqw.fileserver.DfsService#saveFile(java.io.InputStream,
	 * java.lang.String, java.lang.String)
	 */
	public String saveFile(InputStream fileInputStream, String fileName,
			String fileExt) throws FileServerException {
		StorageClient1 storageClient1 = null;
		String fastDFSFileId = null;
		try {
			storageClient1 = stackStroagePoolFactory.getFastDfsStorageClient();
		} catch (Exception e) {
			logger.error(e.getMessage()+" saveFile fileInputStream fastdfs pools is wrong", e);
			throw new FileServerException(e);
		}
		long length;
		try {
			length = fileInputStream.available();
			fastDFSFileId = storageClient1.upload_file1_fis(fileInputStream, length, fileExt, fileName, null, null);
		} catch (Exception e) {
			logger.error(e.getMessage()+" saveFile fileInputStream fastdfs upload  file is wrong", e);
			throw new FileServerException(e);
		}

		return fastDFSFileId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qqw.fileserver.DfsService#getFileByPath(java.lang.String)
	 */
	public byte[] getFileByPath(String path) throws FileServerException {
		StorageClient1 storageClient1 = null;
		byte[] result = null;
		try {
			storageClient1 = stackStroagePoolFactory.getFastDfsStorageClient();
		} catch (Exception e) {
			logger.error(e.getMessage()+" getFileByPath fastdfs pools is wrong", e);
			throw new FileServerException(e);
		}
		try {
			result=storageClient1.download_file1(path);
		} catch (Exception e) {
			logger.error(e.getMessage()+" getFileByPath  fastdfs get file is wrong", e);
			throw new FileServerException(e);
		}
		return result;
	}


	/**
	 * @param stackStroagePoolFactory the stackStroagePoolFactory to set
	 */
	public void setStackStroagePoolFactory(
			StackStroagePoolFactory stackStroagePoolFactory) {
		this.stackStroagePoolFactory = stackStroagePoolFactory;
	}

	
}

/**
 * @文件名称：DfsService.java
 * @类路径：com.qqw.fileserver
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 30, 20124:03:54 PM
 */
package com.qqw.fileserver.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqw.fileserver.exception.FileServerException;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 30, 20124:03:54 PM
 */
public class DfsClientFactory {
	private final static Logger logger =LoggerFactory.getLogger(DfsClientFactory.class);
	private static ApplicationContext context = null;

	static {
		try{
		context = new ClassPathXmlApplicationContext("classpath:dfs-application.xml");
		}catch(Exception e){
			logger.error(" DfsClientFactory init Exception " + e.getMessage(), e);
		  try {
			throw new FileServerException(e);
		} catch (FileServerException e1) {
			logger.error(" Throw Exception Error " + e1.getMessage(), e1);
		}
		}
	}

	public static DfsClient getDfsClient() {
		return (DfsClient) context.getBean("dfsClient");
	}
}

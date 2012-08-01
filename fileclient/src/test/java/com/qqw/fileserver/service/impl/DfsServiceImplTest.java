/**
 * @文件名称：DfsServiceImplTest.java
 * @类路径：com.qqw.fileserver.service.impl
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 31, 20123:12:15 PM
 */
package com.qqw.fileserver.service.impl;

import org.junit.Test;

import com.qqw.fileserver.client.DfsClientFactory;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 31, 20123:12:15 PM
 */
public class DfsServiceImplTest {

	@Test
	public void testSaveFile() throws Exception {
		String path=DfsClientFactory.getDfsClient().saveFile("/home/limeng/Desktop/test.jpg");
		System.out.println(path);
	}

}

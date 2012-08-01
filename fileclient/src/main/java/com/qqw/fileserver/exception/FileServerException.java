/**
 * @文件名称：FileServerException.java
 * @类路径：com.qqw.fileserver.exception
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Jul 30, 20124:09:00 PM
 */
package com.qqw.fileserver.exception;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Jul 30, 20124:09:00 PM
 */
public class FileServerException extends Exception {

	/**
	 * @FieldsserialVersionUID:TODO
	 */
	private static final long serialVersionUID = -3188171742254102359L;

	/**
	 * 
	 * @类名：FileServerException.java
	 * @描述：TODO @See java.lang.Exception
	 */
	public FileServerException() {
		super();
	}

	/**
	 * 
	 * @类名：FileServerException.java
	 * @描述：TODO
	 * @@param message
	 */
	public FileServerException(String message) {
		super("FileServerException :" + message);
	}

	/**
	 * 
	 * @类名：FileServerException.java
	 * @描述：TODO
	 * @@param message
	 * @@param cause
	 */
	public FileServerException(String message, Throwable cause) {
		super("FileServerException :" + message, cause);
	}

	/**
	 * 
	 * @类名：FileServerException.java
	 * @描述：TODO
	 * @@param cause
	 */
	public FileServerException(Throwable cause) {
		super(cause);
	}

}

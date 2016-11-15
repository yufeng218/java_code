package com.my.ssh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数据工具类
 *
 */
public class DataUtil
{
	/**
	 * 使用MD5算法进行加密
	 */
	public static String md5(String src)
	{
		try
		{
			StringBuffer buffer = new StringBuffer();
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			
			byte[] bytes = src.getBytes();
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] target = md.digest(bytes);//加密
			for(byte b : target)
			{
				buffer.append(chars[b >> 4 & 0x0F]);//获取高4位并将其转换为字符，并加入到字符串中
				buffer.append(chars[b & 0x0F]);//获取低4位并将其转换为字符
			}
			return buffer.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

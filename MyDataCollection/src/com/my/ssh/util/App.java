package com.my.ssh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author pc
 *
 */
public class App
{

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		String src = "abc";
		byte[] bytes = src.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] target = md.digest(bytes);//加密
		
		for(byte b : target)
		{
			buffer.append(chars[b >> 4 & 0x0F]);//获取高4位并将其转换为字符，并加入到字符串中
			buffer.append(chars[b & 0x0F]);//获取低4位并将其转换为字符
		}
		System.out.println(buffer.toString());
	}

}

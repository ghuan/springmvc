package com.fanfan.system.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
* Copy right huan.gao 2015-6-17����09:06:18
* All right reserved
* QQ:2223486623 
* description��MD5����
 */
public class MD5 {
	

	 public String md5s(String param) {
		 
		 String str = "";

		 try {
			 	MessageDigest md = MessageDigest.getInstance("MD5");
			 	md.update(param.getBytes());
			 	byte b[] = md.digest();

			 	int i;

			 	StringBuffer buf = new StringBuffer("");
			 	for (int offset = 0; offset < b.length; offset++) {
			 		i = b[offset];
			 		if (i < 0)
			 			i += 256;
			 		if (i < 16)
			 			buf.append("0");
			 		buf.append(Integer.toHexString(i));
			 	}
			 	str = buf.toString();
			 	//System.out.println("result: " + buf.toString());// 32λ�ļ���
			 	//System.out.println("result: " + buf.toString().substring(8, 24));// 16λ�ļ���
		 } catch (NoSuchAlgorithmException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();

		 }
		 
		 return str;
	 }

	 public static void main(String agrs[]) {
	  MD5 md51 = new MD5();
	  System.out.print(md51.md5s("111111"));//����4
	 }

	}

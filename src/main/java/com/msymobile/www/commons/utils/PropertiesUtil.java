package com.msymobile.www.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static String proFileName = "/config/redis.properties";// 正确的
	private static Properties pro;

	static {
		try {
			pro = new Properties();
			InputStream in = ClassLoader.class.getResourceAsStream(proFileName);
			pro.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		String value = pro.getProperty(key);
		return value;
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getValue("redis.max_wait"));
	}

}

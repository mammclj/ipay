package com.msymobile.www.commons.utils.IPUtils;

import org.apache.log4j.Logger;

public class IPAreaInfoThread implements Runnable {
	private static Logger logger = Logger.getLogger(IPAreaInfoThread.class);

	private String ip;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	public IPAreaInfoThread() {
		super();
	}

	public IPAreaInfoThread(String ip) {
		super();
		this.ip = ip;
	}

	public static void main(String[] args) throws Exception {
		String str = "101.254.183.";
		long timeStart = System.currentTimeMillis();
		for(int i=0;i<256;i++){
			Thread.currentThread().sleep(50);
			new Thread(new IPAreaInfoThread(str+i)).start();
		}
	}

	@Override
	public void run() {
		IPUtil.getAddressByIP(ip);
	}

	
	public static void test() {
		int a = 1;
		while (a < 256) {
			if (a == 10) {
				a = a + 1;
				continue;
			}
			int b = 0;
			while (b < 256) {
				if (a == 172 && b > 15 && b < 32) {
					b = b + 1;
					continue;
				}
				if (a == 192 && b == 168) {
					b = b + 1;
					continue;
				}
				int c = 0;
				while (c < 256) {
					String ip = a + "." + b + "." + c + "." + "0";
					// TODO 调用淘宝ip接口
					new Thread(new IPAreaInfoThread(ip)).start();
					c = c +1;
				}
				b = b + 1;
			}
			a = a + 1;
		}
	}
	
}

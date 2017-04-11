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

	public static void main(String[] args) {
		String str = "101.254.183.";
		for(int i=0;i<100;i++){
			new Thread(new IPAreaInfoThread(str+i)).start();
		}
	}

	@Override
	public void run() {
		IPUtil.getAddressByIP(ip);
	}

}

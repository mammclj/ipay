package com.msymobile.www.pay.test;

import org.apache.log4j.Logger;

import com.msymobile.www.commons.utils.IPUtils.IPUtil;

public class IPTest implements Runnable{
	private static Logger logger = Logger.getLogger(IPTest.class);
	private String IP;
	private String result;
	
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static void main(String[] args) {
//		test();
		for(int i=0;i<100;i++){
			String rs = "";
			new Thread(new IPTest("101.254.183."+i,rs)).start();
			logger.info(i+":rs--------------->"+rs);
		}
	}

	@Override
	public void run() {
		try {
			IPUtil.getAddressByIP(IP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public IPTest(String iP,String result) {
		super();
		IP = iP;
		this.result = result;
	}

	public IPTest() {
		super();
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
					System.out.println(ip);
					//new Thread(new IPTest(ip,"")).start();
					c = c +1;
				}
				b = b + 1;
			}
			a = a + 1;
		}
	}

}

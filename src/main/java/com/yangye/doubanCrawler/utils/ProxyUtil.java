package com.yangye.doubanCrawler.utils;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class ProxyUtil {
	private static final String PROXY_SERVER = "proxy.abuyun.com";
	private static final int PROXY_PORT = 9020;

	private static final String PROXY_USER = "";
	private static final String PROXY_PASSWORD = "";

	private static ProxyUtil instance = null;

	private ProxyUtil() {

	}

	public static ProxyUtil getInstance() {
		synchronized (ProxyUtil.class) {
			if (instance == null) {
				instance = new ProxyUtil();
			}
			return instance;
		}
	}

	public static Proxy getProxy() {
		Authenticator.setDefault(new ProxyAuthenticator(PROXY_USER, PROXY_PASSWORD));

		// 创建代理服务器地址对象
		InetSocketAddress addr = new InetSocketAddress(PROXY_SERVER, PROXY_PORT);
		// 创建HTTP类型代理对象
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

		return proxy;
	}
}

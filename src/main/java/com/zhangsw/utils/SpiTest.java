package com.zhangsw.utils;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {
	public static void main(String[] args) {
		ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
		Iterator<HelloService> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			HelloService helloService = iterator.next();
			helloService.sayHello();
		}
	}
}
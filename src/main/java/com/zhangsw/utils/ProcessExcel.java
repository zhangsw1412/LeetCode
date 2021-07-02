package com.zhangsw.utils;

import com.alibaba.excel.EasyExcel;

import java.io.IOException;

public class ProcessExcel {
	public static void main(String[] args) throws IOException {
		String fileName = "/Users/zhangsw/Downloads/1.xlsx";
		EasyExcel.read(fileName, Item.class, new DataListener()).sheet().doRead();
		// File file = new File(fileName);
		// Files.asCharSource(file, Charsets.UTF_8).readLines(new LineProcessor<String>() {
		// 	@SneakyThrows
		// 	@Override
		// 	public boolean processLine(String line) throws IOException {
		// 		String[] tokens = line.split(",");
		// 		String traceId = tokens[0].trim();
		// 		String customerId = tokens[1].trim();
		// 		String gmtCreate = tokens[2].trim();
		// 		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(gmtCreate));
		// 		return true;
		// 	}
		//
		// 	@Override
		// 	public String getResult() {
		// 		return null;
		// 	}
		// });
	}
}
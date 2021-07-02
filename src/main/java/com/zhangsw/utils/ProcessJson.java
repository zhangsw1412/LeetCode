package com.zhangsw.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProcessJson {
	public static void main(String[] args) throws IOException {
		String fileName = "/Users/zhangsw/Desktop/596.txt";
		String raw = Files.asCharSource(new File(fileName), Charsets.UTF_8).readFirstLine();

		DateTimeFormatter origin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter target = DateTimeFormatter.ofPattern("yyyyMMdd");
		List<String> result = new ArrayList<>(550);

		JsonParser jp = new JsonParser();
		assert raw != null;
		JsonObject root = jp.parse(raw).getAsJsonObject();
		JsonObject data = root.getAsJsonObject("data");
		JsonArray list = data.getAsJsonArray("mscTraceDataList");
		System.out.println("total -> " + list.size());

		Iterator<JsonElement> it = list.iterator();
		List<String> traceIds = new ArrayList<>(list.size());
		int counter = 0;
		Set<Integer> customerId = new HashSet<>();
		Set<Integer> poiId = new HashSet<>();
		while (it.hasNext()) {
			JsonElement element = it.next();
			JsonObject object = element.getAsJsonObject();
			if (object.get("settleResult").getAsString().equals("NO_SETTLE")) {

				customerId.add(Integer.parseInt(object.get("customerId").getAsString()));
				poiId.add(Integer.parseInt(object.get("poiId").getAsString()));
				counter++;
				String updateSql = "update msc_trace_back_up_"
				                   + LocalDateTime.parse(object.get("gmtCreate").getAsString(), origin).format(target)
				                   + " set sell_type='BOOKING' where partner_id=2242259 and trace_id='"
				                   + object.get("traceId").getAsString()
				                   + "';";
				System.out.println(updateSql);
				result.add(updateSql);
			}
		}
		System.out.println("hit -> " + counter);

		File outputFile = new File("/Users/zhangsw/Desktop/544.txt");
		outputFile.createNewFile();
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
			result.forEach(s -> {
				writer.println(s);
				writer.flush();
			});
		}
		System.out.println("----------finished----------");
	}
}
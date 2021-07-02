package com.zhangsw.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataListener extends AnalysisEventListener<Item> {
	List<String> result = Lists.newArrayListWithCapacity(500);
	private String columns =
			"(id,order_id,partner_order_id,partner_id,poi_id,product_id,buz_line_id,trace_id,settle_type,sell_type,trace_type,quantity,trace_time,send_time,remarks,single_income,single_floor_income,total_order_income,total_floor_income,deal_with_partner_income,mt_fee,practical_partner_income,pay_income,total_consume_income,refund_income,mt_professional_income,partner_professional_income,total_professional_income,partner_bear_income,mt_bear_income,preferential_total_income,partner_preferential_total_income,mt_preferential_total_income,has_preferential,contract_id,professional_type,settle_result,gmt_create,gmt_modified,preferential_settle_result,order_item_id,vpoi_id,poi_name,product_name,order_type,groupon_flag,settle_time,do_status,bearrefund,sourcepartnerid,sourcepartnername,preferentialsource,payplatform,mt_compensate_income,trace_item_type,contract_company,`version`,currency,time_zone,gross_profit,iph_pay_merchant_no,iph_pay_flow,order_settle_mode,order_commission_mode,partner_refund_income,business_account_type,order_sale_channel,pack_type,product_invoice_mode,c_open_invoice_party,mt_user_fee,mt_partner_fee,order_create_time,trace_invoice_mode,order_id_ext,order_item_id_ext,confirm_status,real_trace_flag,bill_type,transfer_total_income,deductible,check_out_time,expire_settle,business_mode,pay_merchant_id,goods_type,sub_commission_mode,sub_commission_rate,order_traffic_id,order_traffic_mark,transfer_flag,trace_section) value ";
	private DateTimeFormatter origin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private DateTimeFormatter target = DateTimeFormatter.ofPattern("yyyyMMdd");

	@Override
	public void invoke(Item item, AnalysisContext analysisContext) {
		// item.setSell_type("BOOKING");
		String sql = "insert into" + " msc_trace_back_up_" + LocalDateTime.parse(item.getGmt_create(), origin).format(
				target) + " " + columns + item.toString() + ";";
		result.add(sql);
		System.out.println(sql);

		// String updateSql = "update msc_trace_back_up_"
		//                    + LocalDateTime.parse(item.getGmt_create(), origin).format(target)
		//                    + " set sell_type='BOOKING' where id="
		//                    + item.getId()
		//                    + " and trace_id='"
		//                    + item.getTrace_id()
		//                    + "';";
		// System.out.println(updateSql);
		// result.add(updateSql);
	}

	@SneakyThrows
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		File outputFile = new File("/Users/zhangsw/Desktop/1.txt");
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
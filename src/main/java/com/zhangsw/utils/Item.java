package com.zhangsw.utils;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

import java.lang.reflect.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	private Long id;
	@ExcelProperty(converter = LongConverter.class)
	private Long order_id;
	private String partner_order_id;
	@ExcelProperty(converter = LongConverter.class)
	private Long partner_id;
	@ExcelProperty(converter = LongConverter.class)
	private Long poi_id;
	private String product_id;
	@ExcelProperty(converter = LongConverter.class)
	private Long buz_line_id;
	private String trace_id;
	@ExcelProperty(converter = LongConverter.class)
	private Long settle_type;
	private String sell_type;
	private String trace_type;
	@ExcelProperty(converter = LongConverter.class)
	private Long quantity;
	@ExcelProperty(converter = LongConverter.class)
	private Long trace_time;
	@ExcelProperty(converter = LongConverter.class)
	private Long send_time;
	private String remarks;
	@ExcelProperty(converter = LongConverter.class)
	private Long single_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long single_floor_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long total_order_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long total_floor_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long deal_with_partner_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_fee;
	@ExcelProperty(converter = LongConverter.class)
	private Long practical_partner_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long pay_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long total_consume_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long refund_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_professional_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long partner_professional_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long total_professional_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long partner_bear_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_bear_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long preferential_total_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long partner_preferential_total_income;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_preferential_total_income;
	@ExcelProperty(converter = LongConverter.class)
	private int has_preferential;
	private String contract_id;
	private String professional_type;
	private String settle_result;
	private String gmt_create;
	private String gmt_modified;
	private String preferential_settle_result;
	private String order_item_id;
	@ExcelProperty(converter = LongConverter.class)
	private Long vpoi_id;
	private String poi_name;
	private String product_name;
	private String order_type;
	private int groupon_flag;
	@ExcelProperty(converter = LongConverter.class)
	private Long settle_time;
	private String do_status;
	private String bearrefund;
	@ExcelProperty(converter = LongConverter.class)
	private Long sourcepartnerid;
	private String sourcepartnername;
	private String preferentialsource;
	private String payplatform;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_compensate_income;
	private String trace_item_type;
	private String contract_company;
	@ExcelProperty(converter = LongConverter.class)
	private Long version;
	private String currency;
	private String time_zone;
	@ExcelProperty(converter = LongConverter.class)
	private Long gross_profit;
	private String iph_pty_merchant_no;
	private String iph_pay_flow;
	private String order_settle_mode;
	private String order_commission_mode;
	@ExcelProperty(converter = LongConverter.class)
	private Long partner_refund_income;
	private String business_account_type;
	private String order_sale_channel;
	private String pack_type;
	private String product_invoice_mode;
	private String c_open_invoice_party;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_user_fee;
	@ExcelProperty(converter = LongConverter.class)
	private Long mt_partner_fee;
	@ExcelProperty(converter = LongConverter.class)
	private Long order_create_time;
	private String trace_invoice_mode;
	private String order_id_ext;
	private String order_item_id_ext;
	private String confirm_status;
	private String real_trace_flag;
	private String bill_type;
	@ExcelProperty(converter = LongConverter.class)
	private Long transfer_total_income;
	private String deductible;
	@ExcelProperty(converter = LongConverter.class)
	private Long check_out_time;
	private String expire_settle;
	private String business_mode;
	private String pay_merchant_id;
	private String goods_type;
	private String sub_commission_mode;
	private String sub_commission_rate;
	private String order_traffic_id;
	private String order_traffic_mark;
	private String transfer_flag;
	private String trace_section;

	@SneakyThrows
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			stringBuilder.append(",");
			if (String.class.equals(field.getType())) {
				if (field.get(this) == null) {
					stringBuilder.append("''");
				} else if ("NULL".equalsIgnoreCase((String) field.get(this))) {
					stringBuilder.append("null");
				} else {
					stringBuilder.append("'").append(field.get(this)).append("'");
				}
			} else {
				stringBuilder.append(field.get(this));
			}
		}
		stringBuilder.append(")");
		return stringBuilder.deleteCharAt(1).toString();
	}

}
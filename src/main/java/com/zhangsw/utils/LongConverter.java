package com.zhangsw.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class LongConverter implements Converter<Long> {
	@Override
	public Class supportJavaTypeKey() {
		return Long.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Long convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
	                              GlobalConfiguration globalConfiguration) {
		if (cellData.getType().equals(CellDataTypeEnum.STRING)) {
			return "null".equalsIgnoreCase(cellData.getStringValue()) ? null : Long.parseLong(
					cellData.getStringValue());
		} else {
			return cellData.getNumberValue().longValue();
		}
	}

	@Override
	public CellData convertToExcelData(Long aLong, ExcelContentProperty excelContentProperty,
	                                   GlobalConfiguration globalConfiguration) {
		return null;
	}
}

package com.kq.easyexcel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author: kq
 * @date: 2023-11-13 16:14:33
 * @since: 1.0.0
 * @description:
 */
@Slf4j
public class NumberConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *
     * @param context
     * @return
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {

        String originalValue = null;
        if(CellDataTypeEnum.STRING == context.getReadCellData().getType()) {
            originalValue = context.getReadCellData().getStringValue();
        } else  if(CellDataTypeEnum.NUMBER == context.getReadCellData().getType()) {
            originalValue = String.valueOf(context.getReadCellData().getNumberValue());
        }

        if(StringUtils.isBlank(originalValue)){
            return null;
        }

        try {
//            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            return decimalFormat.format(new BigDecimal(originalValue));
        }catch (Exception e){
            log.error("parseError",e);
        }

        return originalValue;

    }

    /**
     * 这里是写的时候会调用 不用管
     *
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        return new WriteCellData<>(context.getValue());
    }

}

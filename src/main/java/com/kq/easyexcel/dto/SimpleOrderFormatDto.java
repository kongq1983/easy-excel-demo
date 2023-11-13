package com.kq.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.kq.easyexcel.converter.NumberConverter;
import lombok.Data;

import java.util.Date;

/**
 * @author: kq
 * @date: 2023-09-01 22:27:51
 * @since: 1.0.0
 * @description:
 */
@Data
public class SimpleOrderFormatDto {

    /**
     * "学号"
     */
    @ExcelProperty(index = 0)
    private String userNumber;

    /**
     * "姓名"
     */
    @ExcelProperty(index = 1)
    private String userName;

    /**
     * "交易流水号"
     */
    @ExcelProperty(index = 2)
    private String payRefGuid;

    /**
     * "支付金额（元）"
     */
    @ExcelProperty(index = 3,converter = NumberConverter.class)
//    @ExcelProperty(index = 3)
    // NumberFormat好像没用
//    @NumberFormat("#.##")
//    @NumberFormat("0.00")
    private String payAmount;

    /**
     * "支付时间"
     */
    @ExcelProperty(index = 4)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private String payDate;



}

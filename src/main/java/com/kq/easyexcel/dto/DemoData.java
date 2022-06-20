package com.kq.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @author kq
 * @date 2022-06-17 13:41
 * @since 2020-0630
 */

@lombok.Data
public class DemoData {

    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

    private String name;
    private String number;

}

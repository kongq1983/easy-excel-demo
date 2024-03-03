package com.kq.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * UserDto
 *
 * @author kq
 * @date 2024-03-03 11:08
 * @since 1.0.0
 */
@Data
public class UserQuarterDto {

    @ExcelProperty("工号")
    private String jobNumber;

    @ExcelProperty("姓名")
    private String name;


    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

    @ExcelProperty("季度列表")
    private List<Quarter> quarters;


    @Data
    public static class Quarter {

        @ExcelProperty("季度名称")
        private String name;

        @ExcelProperty("月份列表")
        private List<Month> months;

    }


    @Data
    public static class Month {

        @ExcelProperty("月份名称")
        private String name;

        @ExcelProperty("得分")
        private BigDecimal score;

    }


}

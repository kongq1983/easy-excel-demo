package com.kq.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 二层静态头(季度-月份)
 *  * UserDto
 * UserQuarterStaticHeadSecondLevelDto
 *
 * @author kq
 * @date 2024-03-03 16:43
 * @since 1.0.0
 */
@Data
public class UserQuarterStaticHeadSecondLevelDto {

    @ExcelProperty(value = "工号",index = 0)
    private String jobNumber;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;

    @ExcelProperty(value = {"一季度", "1月份"},index = 2)
    private BigDecimal month1Score;

    @ExcelProperty(value = {"一季度", "2月份"},index = 3)
    private BigDecimal month2Score;

    @ExcelProperty(value = {"一季度", "3月份"},index = 4)
    private BigDecimal month3Score;

    @ExcelProperty(value = {"二季度", "4月份"},index = 5)
    private BigDecimal month4Score;

    @ExcelProperty(value = {"二季度", "5月份"},index = 6)
    private BigDecimal month5Score;

    @ExcelProperty(value = {"二季度", "6月份"},index = 7)
    private BigDecimal month6Score;

    @ExcelProperty(value = "备注",index = 8)
    private String remark;

}

package com.kq.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: kq
 * @date: 2023-09-01 22:27:51
 * @since: 1.0.0
 * @description:
 */
@Data
public class SimpleOrderIndexDto {

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
    @ExcelProperty(index = 3)
    private String payAmount;

    /**
     * "支付时间"
     */
    @ExcelProperty(index = 4)
    private Date payDate;



}

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
public class OrderFlowDto {

    @ExcelProperty("支付流水号")
    private String payRefGuid;

    @ExcelProperty("交易流水号")
    private String transRefGuid;

    @ExcelProperty("支付金额（单位：元）")
    private String payAmount;

    @ExcelProperty("支付时间")
    private Date payDate;

    @ExcelProperty("学号")
    private String userNumber;

    @ExcelProperty("姓名")
    private String userName;

    @ExcelProperty("项目ID")
    private String projectId;

    @ExcelProperty("订单状态")
    private String statusName;

}

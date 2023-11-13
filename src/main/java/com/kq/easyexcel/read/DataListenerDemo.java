package com.kq.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.kq.easyexcel.dto.OrderFlowDto;
import com.kq.easyexcel.read.listener.DemoDataListener;

/**
 * https://easyexcel.opensource.alibaba.com/docs/current/quickstart/read
 * @author: kq
 * @date: 2023-11-13 14:58:17
 * @since: 1.0.0
 * @description:
 */
public class DataListenerDemo {


    // 写法4
    public static void main4(String[] args) {

        // 一个文件一个reader
        try (ExcelReader excelReader = EasyExcel.read(OrderReadComponent.getInputStream(), OrderFlowDto.class, new DemoDataListener()).build()) {
            // 构建一个sheet 这里可以指定名字或者no
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            // 读取一个sheet
            excelReader.read(readSheet);
        }

    }


    // 写法3
    public static void main(String[] args) {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(OrderReadComponent.getInputStream(), OrderFlowDto.class, new DemoDataListener()).sheet().doRead();

    }

}

package com.kq.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.kq.easyexcel.dto.OrderFlowDto;
import com.kq.easyexcel.dto.SimpleOrderFormatDto;
import com.kq.easyexcel.dto.SimpleOrderIndexDto;

import java.io.InputStream;
import java.util.List;

/**
 * 根据Index
 * @author: kq
 * @date: 2023-11-13 15:20:29
 * @since: 1.0.0
 * @description:
 */
public class SimpleOrderReadExcelDemo {

    public static void main(String[] args) {

        //根据index读取excel
//        readByIndex();

        // 字段格式化
        readFormat();

    }


    public static void readFormat(){
        // 格式化
        List<SimpleOrderFormatDto> list = EasyExcel.read(getInputStream()).head(SimpleOrderFormatDto.class).sheet().doReadSync();

        for (SimpleOrderFormatDto data : list) {
            System.out.println(data);
        }
    }


    /**
     * 根据index读取excel
     */
    public static void readByIndex(){
        // 根据index读取excel
        List<SimpleOrderIndexDto> list = EasyExcel.read(getInputStream()).head(SimpleOrderIndexDto.class).sheet().doReadSync();

        for (SimpleOrderIndexDto data : list) {
            System.out.println(data);
        }
    }


    public static InputStream getInputStream() {
        return OrderReadComponent.class.getResourceAsStream("/templates/simple_order.xlsx");
    }
}

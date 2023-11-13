package com.kq.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.kq.easyexcel.dto.OrderFlowDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: kq
 * @date: 2023-11-13 13:45:47
 * @since: 1.0.0
 * @description:
 */
public class OrderReadComponent {


    public static List<OrderFlowDto> loadAll(String filePath) {


        List<OrderFlowDto> list = EasyExcel.read(filePath).head(OrderFlowDto.class).sheet().doReadSync();
        for (OrderFlowDto data : list) {

            System.out.println(data);

        }

        return list;

    }


    public static List<OrderFlowDto> loadAll(InputStream in) {


        List<OrderFlowDto> list = EasyExcel.read(in).head(OrderFlowDto.class).sheet().doReadSync();
        for (OrderFlowDto data : list) {

            System.out.println(data);

        }

        return list;

    }


    public static void main(String[] args) throws IOException {
        try(InputStream in = OrderReadComponent.class.getResourceAsStream("/templates/exception_order.xlsx")) {
            List<OrderFlowDto> list = loadAll(in);

            for(OrderFlowDto flow : list) {
                System.out.println(flow);
            }

        }
    }


}

package com.kq.easyexcel;

import com.alibaba.excel.util.ListUtils;
import com.kq.easyexcel.dto.DemoData;

import java.util.Date;
import java.util.List;

/**
 * @author kq
 * @date 2022-06-17 14:25
 * @since 2020-0630
 */
public class BaseTest {

    protected List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            data.setNumber(String.valueOf(i));
            data.setName("小王"+i);
            list.add(data);
        }
        return list;
    }

}

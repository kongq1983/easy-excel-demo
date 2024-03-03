package com.kq.easyexcel;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.util.ListUtils;
import com.kq.easyexcel.dto.DemoData;
import com.kq.easyexcel.util.TestFileUtil;

import java.io.File;
import java.io.IOException;
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


    /**
     * 导出文件
     * @param fileName
     * @return
     * @throws IOException
     */
    protected File getExportFile(String fileName) throws IOException {
        File file = new File(TestFileUtil.getPath(),fileName+".xlsx");

        System.out.println("file="+file.getAbsolutePath());

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        return file;
    }

    protected File getExportFile() throws IOException {
        String file = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT);

        return getExportFile(file);
    }

}

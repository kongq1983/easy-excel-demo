package com.kq.easyexcel.write.complex.header;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import org.junit.Test;

/**
 * UserQuarterTest
 *
 * @author kq
 * @date 2024-03-03 15:47
 * @since 1.0.0
 */
public class UserQuarterExportTest extends UserQuarterBaseTest{

    @Test
    public void testExport() throws Exception{

        WriteSheet writeSheet = EasyExcel.writerSheet(0, "员工得分表" ).head(head()).build();

        ExcelWriter writer = EasyExcelFactory.write(this.getExportFile())
                // 核心代码：表头和正文的样式在此
                .build().write(getUserContentDataList(getUserList()),writeSheet);


        writer.close();

    }

//    public static void main(String[] args) throws Exception{
//        new UserQuarterTest().testExport();
//    }

}

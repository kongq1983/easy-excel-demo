package com.kq.easyexcel.write.complex.header;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.google.common.collect.Lists;
import com.kq.easyexcel.dto.UserQuarterDto;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 个性化，样式自己定制
 * UserQuarterCustomizeTest
 *
 * @author kq
 * @date 2024-03-03 11:18
 * @since 1.0.0
 */
public class UserQuarterCustomizeExportTest extends UserQuarterBaseTest{

    @Test
    public void testExport() throws Exception{

        ExcelWriter writer = EasyExcelFactory.write(this.getExportFile())
                // 核心代码：表头和正文的样式在此
                .registerWriteHandler(setConfigure()).build();

        // 动态添加表头，适用一些表头动态变化的场景
        WriteSheet sheet1 = new WriteSheet();
        sheet1.setSheetName("员工得分表");
        sheet1.setSheetNo(0);

        // 创建一个表格，用于 Sheet 中使用
        WriteTable table = new WriteTable();
        table.setTableNo(1);
        // 核心代码：设置表头
        table.setHead(head());

        // 写数据
        writer.write(getUserContentDataList(getUserList()), sheet1, table);
        writer.finish();


    }


    //配置字体，表头背景等
    private HorizontalCellStyleStrategy setConfigure() {
        // 头的样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景色 BLUE_GREY
        headWriteCellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex()); // 黄色背景
        WriteFont headWriteFont = new WriteFont();
        // 加粗
        headWriteFont.setBold(true);
//        headWriteFont.setFontHeightInPoints((short) 14); // 设置行高，不重要
        headWriteCellStyle.setWriteFont(headWriteFont);


        // 内容的样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 字体策略
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
//        contentWriteFont.setFontHeightInPoints((short) 14);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //边框
        //导出数据垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //导出数据水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setBorderLeft(BorderStyle.NONE);
        contentWriteCellStyle.setBorderTop(BorderStyle.NONE);
        contentWriteCellStyle.setBorderRight(BorderStyle.NONE);
        contentWriteCellStyle.setBorderBottom(BorderStyle.NONE);

        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);

        //设置
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }



}

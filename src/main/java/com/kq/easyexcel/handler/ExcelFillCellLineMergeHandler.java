package com.kq.easyexcel.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

/**
 * @author kq
 * @date 2022-06-20 17:30
 * @since 2020-0630
 */
public class ExcelFillCellLineMergeHandler implements CellWriteHandler {
    private int[] mergeColumnIndex; //自定义合并单元格的列 例： int[] mergeColumeIndex = {0, 1, 11};
    private int mergeRowIndex; //自定义合并单元格的行  一般来说填表头行高 例如行高位为3则 int mergeRowIndex = 3;

    public ExcelFillCellLineMergeHandler() {
    }

    public ExcelFillCellLineMergeHandler(int mergeRowIndex, int[] mergeColumnIndex) {
        this.mergeRowIndex = mergeRowIndex;
        this.mergeColumnIndex = mergeColumnIndex;
    }
    //单元格创造之前的操作
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }
    //单元格创造之后的操作
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }
    //afterCellDispose方法是在单元格创建后销毁前的一个时机。这时候我们可以改变单元格内容。
    //mergeColumnIndex 自定义合并单元格的列 例： int[] mergeColumeIndex = {0, 1, 11};
    //mergeRowIndex 自定义合并单元格的行  //一般来说填表头行高 如表头行高位为3则 int mergeRowIndex = 3;

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        int curRowIndex = cell.getRowIndex(); //当前单元格的行数
        int curColIndex = cell.getColumnIndex(); // 当前单元格的列数
        if (curRowIndex > mergeRowIndex) {
            for (int i = 0; i < mergeColumnIndex.length; i++) {
                if (curColIndex == mergeColumnIndex[i]) {
                    //单元格数据处理
                    mergeWithPrevRow(writeSheetHolder, cell, curRowIndex, curColIndex);
                    break;
                }
            }
        }
    }
    /**
     * @description 当前单元格向上合并
     * cell             当前单元格
     * curRowIndex      当前行
     * curColIndex      当前列
     * @author Inori
     * @date 2022/1/26 15:50
     * @params [writeSheetHolder, cell, curRowIndex, curColIndex]
     * @return void
     * @throws
     */
    private void mergeWithPrevRow(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex) {
        //当前单元格中数据
        Object curData = cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.getNumericCellValue();
        //获取当前单元格的上面一个单元格
        Cell preCell = cell.getSheet().getRow(curRowIndex - 1).getCell(curColIndex);
        //获取当前单元格的上面一个单元格中的数据
        Object preData = preCell.getCellType() == CellType.STRING ? preCell.getStringCellValue() : preCell.getNumericCellValue();
        // 将当前单元格数据与上一个单元格数据比较
        if (preData.equals(curData)) {
            //获取当前sheet页
            Sheet sheet = writeSheetHolder.getSheet();
            //得到所有的合并单元格
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            //是否合并
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                //CellRangeAddress POI合并单元格
                //CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol)
                //例子：CellRangeAddress（2, 6000, 3, 3）；
                //第2行起 第6000行终止 第3列开始 第3列结束。
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // cellRangeAddr.isInRange(int rowInd, int colInd)确定给定坐标是否在此范围的范围内。
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(curRowIndex - 1, curColIndex)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastRow(curRowIndex);
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            // 若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex - 1, curRowIndex, curColIndex, curColIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
    }
}

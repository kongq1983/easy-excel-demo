package com.kq.easyexcel.write.complex.header;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.kq.easyexcel.BaseTest;
import com.kq.easyexcel.dto.UserQuarterStaticHeadSecondLevelDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * UserQuarterStaticHeadExportTest
 *
 * @author kq
 * @date 2024-03-03 19:14
 * @since 1.0.0
 */
public class UserQuarterStaticHeadExportTest extends BaseTest {

    @Test
    public void testExport() throws Exception{
        EasyExcel.write(this.getExportFile(), UserQuarterStaticHeadSecondLevelDto.class).sheet("员工得分表").doWrite(userListData());
    }


    private List<UserQuarterStaticHeadSecondLevelDto> userListData(){

        List<UserQuarterStaticHeadSecondLevelDto> list = new ArrayList<>();

        for(int i=1;i<10;i++) {
            UserQuarterStaticHeadSecondLevelDto dto = new UserQuarterStaticHeadSecondLevelDto();
            dto.setJobNumber(String.valueOf(i));
            dto.setName("小王"+i);
            dto.setMonth1Score(new BigDecimal(100-1));
            dto.setMonth2Score(new BigDecimal(100-2));
            dto.setMonth3Score(new BigDecimal(100-3));
            dto.setMonth4Score(new BigDecimal(100-4));
            dto.setMonth5Score(new BigDecimal(100-5));
            dto.setMonth6Score(new BigDecimal(100-6));
            dto.setRemark("备注"+i);

            list.add(dto);
        }


        return list;
    }


}

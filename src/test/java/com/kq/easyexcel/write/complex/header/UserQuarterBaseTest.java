package com.kq.easyexcel.write.complex.header;

import com.alibaba.excel.util.ListUtils;
import com.google.common.collect.Lists;
import com.kq.easyexcel.BaseTest;
import com.kq.easyexcel.dto.UserQuarterDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * UserQuarterTest
 *
 * @author kq
 * @date 2024-03-03 11:18
 * @since 1.0.0
 */
@Slf4j
public class UserQuarterBaseTest extends BaseTest {


    /**
     * 用户数据
     * @param users
     * @return
     */
    protected List<List<Object>> getUserContentDataList(List<UserQuarterDto> users) {
        List<List<Object>> contentList = ListUtils.newArrayList();
        //这里一个List<Object>才代表一行数据，需要映射成每行数据填充，横向填充（把实体数据的字段设置成一个List<Object>）
        //数据根据实际获取进行填充

        for(UserQuarterDto user : users) {
            // 每条用户数据
            List<Object> userData = ListUtils.newArrayList(user.getJobNumber(), user.getName());

            for(UserQuarterDto.Quarter quarters : user.getQuarters()) {

                for(UserQuarterDto.Month month : quarters.getMonths()) {
                    userData.add(month.getScore());
                }
            }

            contentList.add(userData);
        }

        log.debug("getUserContentDataList contentList={}",contentList);

        return contentList;
    }



    /**
     * 表头
     * @return
     */
    protected List<List<String>> head() {

        List<List<String>> headTitles = ListUtils.newArrayList();
        //表头可以根据实际情况进行修改
        headTitles.add(ListUtils.newArrayList( "工号"));
        headTitles.add(ListUtils.newArrayList( "姓名"));
        // 季度列表
        List<UserQuarterDto.Quarter> quarterList = getQuarterList();


        // 季度和月份
        quarterList.forEach(quarter -> {
            quarter.getMonths().forEach(month -> {
                headTitles.add(ListUtils.newArrayList(quarter.getName(), month.getName()));
            });
        });
        headTitles.add(ListUtils.newArrayList("备注"));

        log.debug("head headTitles={}",headTitles);

        return headTitles;
    }


    protected List<UserQuarterDto> getUserList(){

        List<UserQuarterDto> list = Lists.newArrayList();

        for(int i=1;i<10;i++) {

            UserQuarterDto dto = new UserQuarterDto();
            dto.setName("小王"+i);
            dto.setJobNumber(String.valueOf(i));

            dto.setQuarters(getQuarterList());

            list.add(dto);

        }

        return list;

    }

    /**
     * 季度列表
     * @return
     */
    protected List<UserQuarterDto.Quarter> getQuarterList() {
        return Lists.newArrayList(this.getQuarter1(),this.getQuarter2());
    }


    /**
     * 一季度
     * @return
     */
    protected UserQuarterDto.Quarter getQuarter1() {

        UserQuarterDto.Quarter quarter = new UserQuarterDto.Quarter();
        quarter.setName("一季度");

        List<UserQuarterDto.Month> list = Lists.newArrayList();
        for(int i=1;i<=3;i++) {
            UserQuarterDto.Month month = new UserQuarterDto.Month();
            month.setName(i+"月");
            month.setScore(new BigDecimal(100-i));
            list.add(month);
        }

        quarter.setMonths(list);

        return quarter;
    }

    /**
     * 二季度
     * @return
     */
    protected UserQuarterDto.Quarter getQuarter2() {

        UserQuarterDto.Quarter quarter = new UserQuarterDto.Quarter();
        quarter.setName("二季度");

        List<UserQuarterDto.Month> list = Lists.newArrayList();
        for(int i=4;i<=6;i++) {
            UserQuarterDto.Month month = new UserQuarterDto.Month();
            month.setName(i+"月");
            month.setScore(new BigDecimal(100-i));
            list.add(month);
        }

        quarter.setMonths(list);

        return quarter;
    }


}

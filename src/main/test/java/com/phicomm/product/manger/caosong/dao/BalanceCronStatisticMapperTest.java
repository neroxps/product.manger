package com.phicomm.product.manger.caosong.dao;

import com.phicomm.product.manger.dao.BalanceCronStatisticMapper;
import com.phicomm.product.manger.model.statistic.BalanceAccountInfo;
import com.phicomm.product.manger.module.dds.CustomerContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

/**
 * balanceCronStatisticMapper的测试
 *
 * @author song02.cao
 */
@WebAppConfiguration
@ContextConfiguration({"/spring/spring-root.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BalanceCronStatisticMapperTest {

    @Autowired
    BalanceCronStatisticMapper balanceCronStatisticMapper;

    @Test
    public void getTest() {
        CustomerContextHolder.selectLocalDataSource();
        BalanceAccountInfo balanceAccountInfo = balanceCronStatisticMapper.getBalanceAccountInfo();
        System.out.println(balanceAccountInfo);
        CustomerContextHolder.clearDataSource();
    }

    @Test
    public void replaceTest() {
        CustomerContextHolder.selectLocalDataSource();
        balanceCronStatisticMapper.insertUpateBalanceAccountInfo(1, 1, 1);
        CustomerContextHolder.clearDataSource();
    }

    @Test
    public void getUserCountTest() {
        CustomerContextHolder.selectLocalDataSource();
        Map<String, Map<String,Integer>> countMap = balanceCronStatisticMapper.getBalanceUserCountInfo();
        System.out.println("countMap = " + countMap);
    }

    @Test
    public void replaceUserCountTest() {
        CustomerContextHolder.selectLocalDataSource();
        balanceCronStatisticMapper.insertUpdateBalanceUserCountInfo(0, "男", 500);
        balanceCronStatisticMapper.insertUpdateBalanceUserCountInfo(1, "女", 400);
        CustomerContextHolder.clearDataSource();
    }
}

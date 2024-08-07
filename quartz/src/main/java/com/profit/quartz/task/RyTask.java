package com.profit.quartz.task;

import com.profit.bond.service.IBondDealService;
import com.profit.bond.service.IBondInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.profit.common.utils.StringUtils;

/**
 * 定时任务调度测试
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private IBondDealService bondDealService;

    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
//        bondInfoService.refurbishBondPrice();

//        bondDealService.refurbishBondDeal();
    }
}

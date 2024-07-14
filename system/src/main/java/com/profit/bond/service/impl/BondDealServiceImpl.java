package com.profit.bond.service.impl;

import java.util.*;

import com.profit.bond.domain.BondDeal;
import com.profit.bond.domain.BondInfo;
import com.profit.bond.mapper.BondDealMapper;
import com.profit.bond.service.IBondDealService;
import com.profit.bond.service.IBondInfoService;
import com.profit.common.core.text.Convert;
import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import com.profit.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 股票成交基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
@Service
public class BondDealServiceImpl implements IBondDealService
{
    @Autowired
    private BondDealMapper bondDealMapper;
    @Autowired
    private IBondInfoService bondInfoService;
    @Resource
    private RestTemplate restTemplate;

    private String serverUrl = "https://tpdog.com/api/stock/";
    /**
     * 查询股票成交基础信息
     * 
     * @param id 股票成交基础信息主键
     * @return 股票成交基础信息
     */
    @Override
    public BondDeal selectBondDealById(Long id)
    {
        return bondDealMapper.selectBondDealById(id);
    }

    /**
     * 查询股票成交基础信息列表
     * 
     * @param bondDeal 股票成交基础信息
     * @return 股票成交基础信息
     */
    @Override
    public List<BondDeal> selectBondDealList(BondDeal bondDeal)
    {
        return bondDealMapper.selectBondDealList(bondDeal);
    }

    /**
     * 新增股票成交基础信息
     * 
     * @param bondDeal 股票成交基础信息
     * @return 结果
     */
    @Override
    public int insertBondDeal(BondDeal bondDeal)
    {
        bondDeal.setCreateTime(DateUtils.getNowDate());
        return bondDealMapper.insertBondDeal(bondDeal);
    }

    /**
     * 修改股票成交基础信息
     * 
     * @param bondDeal 股票成交基础信息
     * @return 结果
     */
    @Override
    public int updateBondDeal(BondDeal bondDeal)
    {
        bondDeal.setUpdateTime(DateUtils.getNowDate());
        return bondDealMapper.updateBondDeal(bondDeal);
    }

    /**
     * 批量删除股票成交基础信息
     * 
     * @param ids 需要删除的股票成交基础信息主键
     * @return 结果
     */
    @Override
    public int deleteBondDealByIds(String ids)
    {
        return bondDealMapper.deleteBondDealByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票成交基础信息信息
     * 
     * @param id 股票成交基础信息主键
     * @return 结果
     */
    @Override
    public int deleteBondDealById(Long id)
    {
        return bondDealMapper.deleteBondDealById(id);
    }

    @Override
    public void refurbishBondDeal() {
        BondInfo bondInfoDTO = new BondInfo();
        bondInfoDTO.setStatus(0);
        List<BondInfo> list = bondInfoService.selectBondInfoList(bondInfoDTO);
        for (BondInfo bondInfo : list) {
            Date firstOfYear= DateUtils.getCurrentFirstOfYear();
            Date lastOfYear= DateUtils.getCurrentLastOfYear();
            List<String> dates = DateUtils.getDateList((int)firstOfYear.getTime()/1000,(int)lastOfYear.getTime()/1000);
            for(String data:dates){
                Map<String, String> uriMap = new HashMap<>();
                uriMap.put("code", bondInfo.getPlate() + "." + BondUtils.getBaseId(bondInfo.getId()));
                uriMap.put("date", data);
                ResponseEntity responseEntity = restTemplate.getForEntity
                        (
                                HttpUtils.generateRequestParameters(serverUrl, uriMap),
                                String.class
                        );

                if (responseEntity != null) {
                    String reslut = (String) responseEntity.getBody();
                    String[] str = reslut.split("~");
                    try {
                        if (str != null) {
                            bondInfo.setPrice(Double.valueOf(str[3]));
                            Calendar calendar = Calendar.getInstance();
                            int hour = calendar.get(Calendar.HOUR_OF_DAY);
                            if (hour >= 15) {
                                bondInfo.setOldPrice(bondInfo.getPrice());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

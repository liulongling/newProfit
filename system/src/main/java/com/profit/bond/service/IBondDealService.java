package com.profit.bond.service;

import com.profit.bond.domain.BondDeal;

import java.util.List;

/**
 * 股票成交基础信息Service接口
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public interface IBondDealService 
{
    /**
     * 查询股票成交基础信息
     * 
     * @param id 股票成交基础信息主键
     * @return 股票成交基础信息
     */
    public BondDeal selectBondDealById(Long id);

    /**
     * 查询股票成交基础信息列表
     * 
     * @param bondDeal 股票成交基础信息
     * @return 股票成交基础信息集合
     */
    public List<BondDeal> selectBondDealList(BondDeal bondDeal);

    /**
     * 新增股票成交基础信息
     * 
     * @param bondDeal 股票成交基础信息
     * @return 结果
     */
    public int insertBondDeal(BondDeal bondDeal);

    /**
     * 修改股票成交基础信息
     * 
     * @param bondDeal 股票成交基础信息
     * @return 结果
     */
    public int updateBondDeal(BondDeal bondDeal);

    /**
     * 批量删除股票成交基础信息
     * 
     * @param ids 需要删除的股票成交基础信息主键集合
     * @return 结果
     */
    public int deleteBondDealByIds(String ids);

    /**
     * 删除股票成交基础信息信息
     * 
     * @param id 股票成交基础信息主键
     * @return 结果
     */
    public int deleteBondDealById(Long id);

    /**
     * 更新股票成交基础信息信息
     *
     * @return 结果
     */
    void refurbishBondDeal();
}

package com.profit.bond.service;

import java.util.List;
import com.profit.bond.domain.BondSellLog;
import com.profit.bond.domain.BondSellLogExample;

/**
 * 股票出售日志Service接口
 * 
 * @author liulongling
 * @date 2023-12-11
 */
public interface IBondSellLogService 
{
    /**
     * 查询股票出售日志
     * 
     * @param id 股票出售日志主键
     * @return 股票出售日志
     */
    public BondSellLog selectBondSellLogById(Long id);

    /**
     * 查询股票出售日志列表
     * 
     * @param bondSellLog 股票出售日志
     * @return 股票出售日志集合
     */
    public List<BondSellLog> selectBondSellLogList(BondSellLog bondSellLog);

    /**
     * 新增股票出售日志
     * 
     * @param bondSellLog 股票出售日志
     * @return 结果
     */
    public int insertBondSellLog(BondSellLog bondSellLog);

    /**
     * 修改股票出售日志
     * 
     * @param bondSellLog 股票出售日志
     * @return 结果
     */
    public int updateBondSellLog(BondSellLog bondSellLog);

    /**
     * 批量删除股票出售日志
     * 
     * @param ids 需要删除的股票出售日志主键集合
     * @return 结果
     */
    public int deleteBondSellLogByIds(String ids);

    /**
     * 删除股票出售日志信息
     * 
     * @param id 股票出售日志主键
     * @return 结果
     */
    public int deleteBondSellLogById(Long id);

    /**
     * 查询股票出售日志列表
     *
     * @param example 股票出售日志
     * @return 股票出售日志集合
     */
    List<BondSellLog> selectByExample(BondSellLogExample example);
}

package com.profit.bond.service;

import java.util.List;
import com.profit.bond.domain.BondBuyLog;
import com.profit.bond.domain.BondBuyLogExample;

/**
 * 股票购买日志Service接口
 * 
 * @author liulongling
 * @date 2023-12-11
 */
public interface IBondBuyLogService 
{
    /**
     * 查询股票购买日志
     * 
     * @param id 股票购买日志主键
     * @return 股票购买日志
     */
    public BondBuyLog selectBondBuyLogById(Long id);

    /**
     * 查询股票购买日志列表
     * 
     * @param bondBuyLog 股票购买日志
     * @return 股票购买日志集合
     */
    public List<BondBuyLog> selectBondBuyLogList(BondBuyLog bondBuyLog);

    /**
     * 新增股票购买日志
     * 
     * @param bondBuyLog 股票购买日志
     * @return 结果
     */
    public int insertBondBuyLog(BondBuyLog bondBuyLog);

    /**
     * 修改股票购买日志
     * 
     * @param bondBuyLog 股票购买日志
     * @return 结果
     */
    public int updateBondBuyLog(BondBuyLog bondBuyLog);

    /**
     * 批量删除股票购买日志
     * 
     * @param ids 需要删除的股票购买日志主键集合
     * @return 结果
     */
    public int deleteBondBuyLogByIds(String ids);

    /**
     * 删除股票购买日志信息
     * 
     * @param id 股票购买日志主键
     * @return 结果
     */
    public int deleteBondBuyLogById(Long id);

    /**
     * 查询股票购买日志列表
     *
     * @param bondBuyLog 股票购买日志
     * @return 股票购买日志集合
     */
    public List<BondBuyLog> selectByExample(BondBuyLogExample bondBuyLogExample);
}

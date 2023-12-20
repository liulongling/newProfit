package com.profit.bond.mapper;

import java.util.List;
import java.util.Map;

import com.profit.bond.domain.BondBuyLog;
import com.profit.bond.domain.BondBuyLogExample;
import org.apache.ibatis.annotations.Param;

/**
 * 股票购买日志Mapper接口
 *
 * @author liulongling
 * @date 2023-12-11
 */
public interface BondBuyLogMapper {
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
     * 删除股票购买日志
     *
     * @param id 股票购买日志主键
     * @return 结果
     */
    public int deleteBondBuyLogById(Long id);

    /**
     * 批量删除股票购买日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBondBuyLogByIds(String[] ids);

    /**
     * 查询出售收益
     *
     * @param gp_id 股票ID
     * @param type  股票类型
     * @return
     */
    Double sumSellIncome(@Param("gp_id") String gp_id, @Param("type") Byte type);

    /**
     * 查询所有利息
     *
     * @return
     */
    Double sumInterest();

    /**
     * 查询股票购买和出售总数量
     *
     * @param gp_id 股票
     * @param type  类型
     * @return
     */
    Map<Object, Object> sumBuySellCount(@Param("gp_id") String gp_id, @Param("type") Byte type);


    /**
     * 查询股票购买日志列表
     *
     * @param example 股票购买日志
     * @return 股票购买日志集合
     */
    List<BondBuyLog> selectByExample(BondBuyLogExample example);
}

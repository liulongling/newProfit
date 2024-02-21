package com.profit.bond.mapper;

import java.util.List;
import java.util.Map;

import com.profit.bond.domain.BondSellLog;
import com.profit.bond.domain.BondSellLogExample;
import com.profit.bond.dto.BondSellRequestDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 股票出售日志Mapper接口
 *
 * @author liulongling
 * @date 2023-12-11
 */
public interface BondSellLogMapper {
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
     * 删除股票出售日志
     *
     * @param id 股票出售日志主键
     * @return 结果
     */
    public int deleteBondSellLogById(Long id);

    /**
     * 批量删除股票出售日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBondSellLogByIds(String[] ids);

    long countByExample(BondSellLogExample example);

    List<Map<Object, Object>> listGroupByGpId(@Param("request") BondSellRequestDTO request);

    List<Map<Object, Object>> listIncomeGroupByDate(@Param("request") BondSellRequestDTO request);

    double sumIncomeByGpId(@Param("request") BondSellRequestDTO request);

    double sumIncomeByType(@Param("request") BondSellRequestDTO request);

    Double sumCost(@Param("request") BondSellRequestDTO request);

    Double sumIncome(@Param("request") BondSellRequestDTO request);

    /**
     * 亏损金额
     *
     * @param request
     * @return
     */
    Double sumLossIncome(@Param("request") BondSellRequestDTO request);

    /**
     *  支出利息
     *
     * @param request
     * @return
     */
    Double sumInterest(@Param("request") BondSellRequestDTO request);

    List<BondSellLog> selectByExample(BondSellLogExample bondSellLogExample);
}

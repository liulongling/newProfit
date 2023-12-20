package com.profit.bond.mapper;

import com.profit.bond.domain.BondStatistics;

import java.util.List;

/**
 * 股票信息Mapper接口
 * 
 * @author liulongling
 * @date 2023-12-13
 */
public interface BondStatisticsMapper 
{
    /**
     * 查询股票信息
     * 
     * @param id 股票信息主键
     * @return 股票信息
     */
    public BondStatistics selectBondStatisticsById(Long id);

    /**
     * 查询股票信息列表
     * 
     * @param bondStatistics 股票信息
     * @return 股票信息集合
     */
    public List<BondStatistics> selectBondStatisticsList(BondStatistics bondStatistics);

    /**
     * 新增股票信息
     * 
     * @param bondStatistics 股票信息
     * @return 结果
     */
    public int insertBondStatistics(BondStatistics bondStatistics);

    /**
     * 修改股票信息
     * 
     * @param bondStatistics 股票信息
     * @return 结果
     */
    public int updateBondStatistics(BondStatistics bondStatistics);

    /**
     * 删除股票信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    public int deleteBondStatisticsById(Long id);

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBondStatisticsByIds(String[] ids);
}

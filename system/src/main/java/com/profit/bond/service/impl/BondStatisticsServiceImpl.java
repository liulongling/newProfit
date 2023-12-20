package com.profit.bond.service.impl;

import java.util.List;

import com.profit.bond.domain.BondStatistics;
import com.profit.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profit.bond.mapper.BondStatisticsMapper;
import com.profit.bond.service.IBondStatisticsService;
import com.profit.common.core.text.Convert;

/**
 * 股票信息Service业务层处理
 * 
 * @author liulongling
 * @date 2023-12-13
 */
@Service
public class BondStatisticsServiceImpl implements IBondStatisticsService 
{
    @Autowired
    private BondStatisticsMapper bondStatisticsMapper;

    /**
     * 查询股票信息
     * 
     * @param id 股票信息主键
     * @return 股票信息
     */
    @Override
    public BondStatistics selectBondStatisticsById(Long id)
    {
        return bondStatisticsMapper.selectBondStatisticsById(id);
    }

    /**
     * 查询股票信息列表
     * 
     * @param bondStatistics 股票信息
     * @return 股票信息
     */
    @Override
    public List<BondStatistics> selectBondStatisticsList(BondStatistics bondStatistics)
    {
        return bondStatisticsMapper.selectBondStatisticsList(bondStatistics);
    }

    /**
     * 新增股票信息
     * 
     * @param bondStatistics 股票信息
     * @return 结果
     */
    @Override
    public int insertBondStatistics(BondStatistics bondStatistics)
    {
        return bondStatisticsMapper.insertBondStatistics(bondStatistics);
    }

    /**
     * 修改股票信息
     * 
     * @param bondStatistics 股票信息
     * @return 结果
     */
    @Override
    public int updateBondStatistics(BondStatistics bondStatistics)
    {
        bondStatistics.setUpdateTime(DateUtils.getNowDate());
        return bondStatisticsMapper.updateBondStatistics(bondStatistics);
    }

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的股票信息主键
     * @return 结果
     */
    @Override
    public int deleteBondStatisticsByIds(String ids)
    {
        return bondStatisticsMapper.deleteBondStatisticsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票信息信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    @Override
    public int deleteBondStatisticsById(Long id)
    {
        return bondStatisticsMapper.deleteBondStatisticsById(id);
    }
}

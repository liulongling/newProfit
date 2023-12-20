package com.profit.bond.service.impl;

import java.util.List;

import com.profit.bond.domain.BondSellLogExample;
import com.profit.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profit.bond.mapper.BondSellLogMapper;
import com.profit.bond.domain.BondSellLog;
import com.profit.bond.service.IBondSellLogService;
import com.profit.common.core.text.Convert;

/**
 * 股票出售日志Service业务层处理
 * 
 * @author liulongling
 * @date 2023-12-11
 */
@Service
public class BondSellLogServiceImpl implements IBondSellLogService 
{
    @Autowired
    private BondSellLogMapper bondSellLogMapper;

    /**
     * 查询股票出售日志
     * 
     * @param id 股票出售日志主键
     * @return 股票出售日志
     */
    @Override
    public BondSellLog selectBondSellLogById(Long id)
    {
        return bondSellLogMapper.selectBondSellLogById(id);
    }

    /**
     * 查询股票出售日志列表
     * 
     * @param bondSellLog 股票出售日志
     * @return 股票出售日志
     */
    @Override
    public List<BondSellLog> selectBondSellLogList(BondSellLog bondSellLog)
    {
        return bondSellLogMapper.selectBondSellLogList(bondSellLog);
    }

    /**
     * 新增股票出售日志
     * 
     * @param bondSellLog 股票出售日志
     * @return 结果
     */
    @Override
    public int insertBondSellLog(BondSellLog bondSellLog)
    {
        bondSellLog.setCreateTime(DateUtils.getNowDate());
        return bondSellLogMapper.insertBondSellLog(bondSellLog);
    }

    /**
     * 修改股票出售日志
     * 
     * @param bondSellLog 股票出售日志
     * @return 结果
     */
    @Override
    public int updateBondSellLog(BondSellLog bondSellLog)
    {
        return bondSellLogMapper.updateBondSellLog(bondSellLog);
    }

    /**
     * 批量删除股票出售日志
     * 
     * @param ids 需要删除的股票出售日志主键
     * @return 结果
     */
    @Override
    public int deleteBondSellLogByIds(String ids)
    {
        return bondSellLogMapper.deleteBondSellLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票出售日志信息
     * 
     * @param id 股票出售日志主键
     * @return 结果
     */
    @Override
    public int deleteBondSellLogById(Long id)
    {
        return bondSellLogMapper.deleteBondSellLogById(id);
    }

    @Override
    public List<BondSellLog> selectByExample(BondSellLogExample example) {
        return bondSellLogMapper.selectByExample(example);
    }
}

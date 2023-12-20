package com.profit.bond.service.impl;

import java.util.List;

import com.profit.bond.domain.BondBuyLogExample;
import com.profit.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profit.bond.mapper.BondBuyLogMapper;
import com.profit.bond.domain.BondBuyLog;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.common.core.text.Convert;

/**
 * 股票购买日志Service业务层处理
 * 
 * @author liulongling
 * @date 2023-12-11
 */
@Service
public class BondBuyLogServiceImpl implements IBondBuyLogService 
{
    @Autowired
    private BondBuyLogMapper bondBuyLogMapper;

    /**
     * 查询股票购买日志
     * 
     * @param id 股票购买日志主键
     * @return 股票购买日志
     */
    @Override
    public BondBuyLog selectBondBuyLogById(Long id)
    {
        return bondBuyLogMapper.selectBondBuyLogById(id);
    }

    /**
     * 查询股票购买日志列表
     * 
     * @param bondBuyLog 股票购买日志
     * @return 股票购买日志
     */
    @Override
    public List<BondBuyLog> selectBondBuyLogList(BondBuyLog bondBuyLog)
    {
        return bondBuyLogMapper.selectBondBuyLogList(bondBuyLog);
    }

    /**
     * 新增股票购买日志
     * 
     * @param bondBuyLog 股票购买日志
     * @return 结果
     */
    @Override
    public int insertBondBuyLog(BondBuyLog bondBuyLog)
    {
        bondBuyLog.setCreateTime(DateUtils.getNowDate());
        return bondBuyLogMapper.insertBondBuyLog(bondBuyLog);
    }

    /**
     * 修改股票购买日志
     * 
     * @param bondBuyLog 股票购买日志
     * @return 结果
     */
    @Override
    public int updateBondBuyLog(BondBuyLog bondBuyLog)
    {
        return bondBuyLogMapper.updateBondBuyLog(bondBuyLog);
    }

    /**
     * 批量删除股票购买日志
     * 
     * @param ids 需要删除的股票购买日志主键
     * @return 结果
     */
    @Override
    public int deleteBondBuyLogByIds(String ids)
    {
        return bondBuyLogMapper.deleteBondBuyLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票购买日志信息
     * 
     * @param id 股票购买日志主键
     * @return 结果
     */
    @Override
    public int deleteBondBuyLogById(Long id)
    {
        return bondBuyLogMapper.deleteBondBuyLogById(id);
    }

    @Override
    public List<BondBuyLog> selectByExample(BondBuyLogExample bondBuyLogExample) {
        return bondBuyLogMapper.selectByExample(bondBuyLogExample);
    }
}

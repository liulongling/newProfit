package com.profit.bond.service;

import java.util.List;
import com.profit.bond.domain.BondInfo;

/**
 * 股票信息Service接口
 * 
 * @author liulongling
 * @date 2023-12-10
 */
public interface IBondInfoService 
{

    /**
     * 股票状态修改
     *
     * @param bondInfo 股票信息
     * @return 结果
     */
    public int changeStatus(BondInfo bondInfo);

    /**
     * 查询股票信息
     * 
     * @param id 股票信息主键
     * @return 股票信息
     */
    public BondInfo selectBondInfoById(String id);

    /**
     * 查询股票信息列表
     * 
     * @param bondInfo 股票信息
     * @return 股票信息集合
     */
    public List<BondInfo> selectBondInfoList(BondInfo bondInfo);

    /**
     * 新增股票信息
     * 
     * @param bondInfo 股票信息
     * @return 结果
     */
    public int insertBondInfo(BondInfo bondInfo);

    /**
     * 修改股票信息
     * 
     * @param bondInfo 股票信息
     * @return 结果
     */
    public int updateBondInfo(BondInfo bondInfo);

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的股票信息主键集合
     * @return 结果
     */
    public int deleteBondInfoByIds(String ids);

    /**
     * 删除股票信息信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    public int deleteBondInfoById(String id);
}

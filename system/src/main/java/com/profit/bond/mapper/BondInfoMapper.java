package com.profit.bond.mapper;

import java.util.List;
import com.profit.bond.domain.BondInfo;

/**
 * 股票信息Mapper接口
 * 
 * @author liulongling
 * @date 2023-12-10
 */
public interface BondInfoMapper 
{
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
     * 删除股票信息
     * 
     * @param id 股票信息主键
     * @return 结果
     */
    public int deleteBondInfoById(String id);

    /**
     * 批量删除股票信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBondInfoByIds(String[] ids);
}

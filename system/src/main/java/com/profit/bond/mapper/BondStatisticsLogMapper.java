package com.profit.bond.mapper;

import com.profit.bond.domain.BondStatisticsLog;
import com.profit.bond.domain.BondStatisticsLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BondStatisticsLogMapper {
    long countByExample(BondStatisticsLogExample example);

    int deleteByExample(BondStatisticsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BondStatisticsLog record);

    int insertSelective(BondStatisticsLog record);

    List<BondStatisticsLog> selectByExample(BondStatisticsLogExample example);

    BondStatisticsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BondStatisticsLog record, @Param("example") BondStatisticsLogExample example);

    int updateByExample(@Param("record") BondStatisticsLog record, @Param("example") BondStatisticsLogExample example);

    int updateByPrimaryKeySelective(BondStatisticsLog record);

    int updateByPrimaryKey(BondStatisticsLog record);
}
package com.profit.bond.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import com.profit.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.profit.bond.mapper.BondInfoMapper;
import com.profit.bond.domain.BondInfo;
import com.profit.bond.service.IBondInfoService;
import com.profit.common.core.text.Convert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 股票信息Service业务层处理
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Service
public class BondInfoServiceImpl implements IBondInfoService {
    @Autowired
    private BondInfoMapper bondInfoMapper;
    @Resource
    private RestTemplate restTemplate;

    private String serverUrl = "http://qt.gtimg.cn/";

    @Override
    public int changeStatus(BondInfo bondInfo) {
        return bondInfoMapper.updateBondInfo(bondInfo);
    }

    /**
     * 查询股票信息
     *
     * @param id 股票信息主键
     * @return 股票信息
     */
    @Override
    public BondInfo selectBondInfoById(String id) {
        return bondInfoMapper.selectBondInfoById(id);
    }

    /**
     * 查询股票信息列表
     *
     * @param bondInfo 股票信息
     * @return 股票信息
     */
    @Override
    public List<BondInfo> selectBondInfoList(BondInfo bondInfo) {
        return bondInfoMapper.selectBondInfoList(bondInfo);
    }

    /**
     * 新增股票信息
     *
     * @param bondInfo 股票信息
     * @return 结果
     */
    @Override
    public int insertBondInfo(BondInfo bondInfo) {
        bondInfo.setCreateTime(DateUtils.getNowDate());
        return bondInfoMapper.insertBondInfo(bondInfo);
    }

    /**
     * 修改股票信息
     *
     * @param bondInfo 股票信息
     * @return 结果
     */
    @Override
    public int updateBondInfo(BondInfo bondInfo) {
        bondInfo.setUpdateTime(DateUtils.getNowDate());
        return bondInfoMapper.updateBondInfo(bondInfo);
    }

    /**
     * 批量删除股票信息
     *
     * @param ids 需要删除的股票信息主键
     * @return 结果
     */
    @Override
    public int deleteBondInfoByIds(String ids) {
        return bondInfoMapper.deleteBondInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除股票信息信息
     *
     * @param id 股票信息主键
     * @return 结果
     */
    @Override
    public int deleteBondInfoById(String id) {
        return bondInfoMapper.deleteBondInfoById(id);
    }

    @Override
    public void refurbishBondPrice() {
        BondInfo bondInfoDTO = new BondInfo();
        bondInfoDTO.setStatus(0);
        List<BondInfo> list = selectBondInfoList(bondInfoDTO);
        for (BondInfo bondInfo : list) {
            Map<String, String> uriMap = new HashMap<>();
            uriMap.put("q", bondInfo.getPlate() + BondUtils.getBaseId(bondInfo.getId()));
            ResponseEntity responseEntity = restTemplate.getForEntity
                    (
                            HttpUtils.generateRequestParameters(serverUrl, uriMap),
                            String.class
                    );

            if (responseEntity != null) {
                String reslut = (String) responseEntity.getBody();
                String[] str = reslut.split("~");
                try {
                    if (str != null) {
                        bondInfo.setPrice(Double.valueOf(str[3]));
                        Calendar calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);
                        if (hour >= 15) {
                            bondInfo.setOldPrice(bondInfo.getPrice());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                updateBondInfo(bondInfo);
            }
        }
    }
}

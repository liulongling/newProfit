package com.profit.web.vo;

import com.profit.bond.domain.BondInfo;
import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: liulongling
 * @date: 2024/3/4
 */
@Builder
public class BondInfoVo extends BondInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3324722711990774987L;

    /** 5日线 */
    private Double fiveDaily;
    /** 10日线 */
    private Double tenDaily;
    /** 20日线 */
    private Double twentyDaily;
}

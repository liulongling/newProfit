package com.profit.web.controller.bond;

import com.profit.bond.domain.BondInfo;
import com.profit.bond.dto.BondInfoDTO;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.bond.service.IBondInfoService;
import com.profit.bond.service.IBondService;
import com.profit.common.annotation.Log;
import com.profit.common.core.controller.BaseController;
import com.profit.common.core.domain.AjaxResult;
import com.profit.common.core.page.TableDataInfo;
import com.profit.common.enums.BusinessType;
import com.profit.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 股票信息Controller
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Controller
@RequestMapping("/bond/oper")
public class BondController extends BaseController {
    private String prefix = "/bond/oper";

    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private IBondBuyLogService bondBuyLogService;
    @Autowired
    private IBondService bondService;


}

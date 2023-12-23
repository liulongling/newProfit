package com.profit.web.controller.bond;

import java.util.List;

import com.profit.bond.service.IBondService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.profit.common.annotation.Log;
import com.profit.common.enums.BusinessType;
import com.profit.bond.domain.BondInfo;
import com.profit.bond.service.IBondInfoService;
import com.profit.common.core.controller.BaseController;
import com.profit.common.core.domain.AjaxResult;
import com.profit.common.core.page.TableDataInfo;

/**
 * 股票信息Controller
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Controller
@RequestMapping("/bond/manager")
public class BondController extends BaseController {
    private String prefix = "/bond/manager";

    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private IBondService bondService;

    /**
     * 股票状态修改
     */
    @Log(title = "股票管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("bond:manager:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(BondInfo bondInfo) {
        return toAjax(bondInfoService.changeStatus(bondInfo));
    }

    @RequiresPermissions("bond:manager:view")
    @GetMapping()
    public String info() {
        return prefix + "/bond";
    }

    /**
     * 查询股票详细
     */
    @RequiresPermissions("system:manager:list")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("bond", bondInfoService.selectBondInfoById(id));
        BondInfo bondInfo = new BondInfo();
        bondInfo.setStatus(0);
        mmap.put("bondList", bondInfoService.selectBondInfoList(bondInfo));
        return "/bond/oper/data";
    }

    /**
     * 查询股票信息列表
     */
    @RequiresPermissions("bond:manager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BondInfo bondInfo) {
        startPage();
        List<BondInfo> list = bondInfoService.selectBondInfoList(bondInfo);
        return getDataTable(list);
    }

    /**
     * 新增股票信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存股票信息
     */
    @RequiresPermissions("bond:manager:add")
    @Log(title = "股票信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BondInfo bondInfo) {
        return toAjax(bondInfoService.insertBondInfo(bondInfo));
    }

    /**
     * 修改股票信息
     */
    @RequiresPermissions("bond:manager:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        BondInfo bondInfo = bondInfoService.selectBondInfoById(id);
        mmap.put("bondInfo", bondInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存股票信息
     */
    @RequiresPermissions("bond:manager:edit")
    @Log(title = "股票信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BondInfo bondInfo) {
        return toAjax(bondInfoService.updateBondInfo(bondInfo));
    }

    /**
     * 删除股票信息
     */
    @RequiresPermissions("bond:manager:remove")
    @Log(title = "股票信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(bondInfoService.deleteBondInfoByIds(ids));
    }
}

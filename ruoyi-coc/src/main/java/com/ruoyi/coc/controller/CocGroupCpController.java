package com.ruoyi.coc.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.service.ICocGroupCpService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团体与企业或个人关系Controller
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/coc/cp")
public class CocGroupCpController extends BaseController
{
    private String prefix = "coc/cp";

    @Autowired
    private ICocGroupCpService cocGroupCpService;

    @RequiresPermissions("coc:cp:view")
    @GetMapping()
    public String cp()
    {
        return prefix + "/cp";
    }

    /**
     * 查询团体与企业或个人关系列表
     */
    @RequiresPermissions("coc:cp:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CocGroupCp cocGroupCp)
    {
        startPage();
        List<CocGroupCp> list = cocGroupCpService.selectCocGroupCpList(cocGroupCp);
        return getDataTable(list);
    }

    /**
     * 导出团体与企业或个人关系列表
     */
    @RequiresPermissions("coc:cp:export")
    @Log(title = "团体与企业或个人关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CocGroupCp cocGroupCp)
    {
        List<CocGroupCp> list = cocGroupCpService.selectCocGroupCpList(cocGroupCp);
        ExcelUtil<CocGroupCp> util = new ExcelUtil<CocGroupCp>(CocGroupCp.class);
        return util.exportExcel(list, "cp");
    }

    /**
     * 新增团体与企业或个人关系
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存团体与企业或个人关系
     */
    @RequiresPermissions("coc:cp:add")
    @Log(title = "团体与企业或个人关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CocGroupCp cocGroupCp)
    {
        return toAjax(cocGroupCpService.insertCocGroupCp(cocGroupCp));
    }

    /**
     * 修改团体与企业或个人关系
     */
    @GetMapping("/edit/{gCode}")
    public String edit(@PathVariable("gCode") String gCode, ModelMap mmap)
    {
        CocGroupCp cocGroupCp = cocGroupCpService.selectCocGroupCpById(gCode);
        mmap.put("cocGroupCp", cocGroupCp);
        return prefix + "/edit";
    }

    /**
     * 修改保存团体与企业或个人关系
     */
    @RequiresPermissions("coc:cp:edit")
    @Log(title = "团体与企业或个人关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CocGroupCp cocGroupCp)
    {
        return toAjax(cocGroupCpService.updateCocGroupCp(cocGroupCp));
    }

    /**
     * 删除团体与企业或个人关系
     */
    @RequiresPermissions("coc:cp:remove")
    @Log(title = "团体与企业或个人关系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cocGroupCpService.deleteCocGroupCpByIds(ids));
    }
}

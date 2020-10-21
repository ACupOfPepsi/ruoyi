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
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocUserGcpService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户与社团、企业、个人关系Controller
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/coc/gcp")
public class CocUserGcpController extends BaseController
{
    private String prefix = "coc/gcp";

    @Autowired
    private ICocUserGcpService cocUserGcpService;

    @RequiresPermissions("coc:gcp:view")
    @GetMapping()
    public String gcp()
    {
        return prefix + "/gcp";
    }

    /**
     * 查询用户与社团、企业、个人关系列表
     */
    @RequiresPermissions("coc:gcp:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CocUserGcp cocUserGcp)
    {
        startPage();
        List<CocUserGcp> list = cocUserGcpService.selectCocUserGcpList(cocUserGcp);
        return getDataTable(list);
    }

    /**
     * 导出用户与社团、企业、个人关系列表
     */
    @RequiresPermissions("coc:gcp:export")
    @Log(title = "用户与社团、企业、个人关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CocUserGcp cocUserGcp)
    {
        List<CocUserGcp> list = cocUserGcpService.selectCocUserGcpList(cocUserGcp);
        ExcelUtil<CocUserGcp> util = new ExcelUtil<CocUserGcp>(CocUserGcp.class);
        return util.exportExcel(list, "gcp");
    }

    /**
     * 新增用户与社团、企业、个人关系
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户与社团、企业、个人关系
     */
    @RequiresPermissions("coc:gcp:add")
    @Log(title = "用户与社团、企业、个人关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CocUserGcp cocUserGcp)
    {
        return toAjax(cocUserGcpService.insertCocUserGcp(cocUserGcp));
    }

    /**
     * 修改用户与社团、企业、个人关系
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        CocUserGcp cocUserGcp = cocUserGcpService.selectCocUserGcpById(userId);
        mmap.put("cocUserGcp", cocUserGcp);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户与社团、企业、个人关系
     */
    @RequiresPermissions("coc:gcp:edit")
    @Log(title = "用户与社团、企业、个人关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CocUserGcp cocUserGcp)
    {
        return toAjax(cocUserGcpService.updateCocUserGcp(cocUserGcp));
    }

    /**
     * 删除用户与社团、企业、个人关系
     */
    @RequiresPermissions("coc:gcp:remove")
    @Log(title = "用户与社团、企业、个人关系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cocUserGcpService.deleteCocUserGcpByIds(ids));
    }
}

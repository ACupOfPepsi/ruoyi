package com.ruoyi.cms.controller;

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
import com.ruoyi.cms.domain.CmsNotice;
import com.ruoyi.cms.service.ICmsNoticeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@Controller
@RequestMapping("/cms/notice")
public class CmsNoticeController extends BaseController
{
    private String prefix = "cms/notice";

    @Autowired
    private ICmsNoticeService cmsNoticeService;

    @RequiresPermissions("cms:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询公告信息列表
     */
    @RequiresPermissions("cms:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsNotice cmsNotice)
    {
        startPage();
        List<CmsNotice> list = cmsNoticeService.selectCmsNoticeList(cmsNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告信息列表
     */
    @RequiresPermissions("cms:notice:export")
    @Log(title = "公告信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsNotice cmsNotice)
    {
        List<CmsNotice> list = cmsNoticeService.selectCmsNoticeList(cmsNotice);
        ExcelUtil<CmsNotice> util = new ExcelUtil<CmsNotice>(CmsNotice.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 新增公告信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告信息
     */
    @RequiresPermissions("cms:notice:add")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsNotice cmsNotice)
    {
        return toAjax(cmsNoticeService.insertCmsNotice(cmsNotice));
    }

    /**
     * 修改公告信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        CmsNotice cmsNotice = cmsNoticeService.selectCmsNoticeById(id);
        mmap.put("cmsNotice", cmsNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存公告信息
     */
    @RequiresPermissions("cms:notice:edit")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsNotice cmsNotice)
    {
        return toAjax(cmsNoticeService.updateCmsNotice(cmsNotice));
    }

    /**
     * 删除公告信息
     */
    @RequiresPermissions("cms:notice:remove")
    @Log(title = "公告信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cmsNoticeService.deleteCmsNoticeByIds(ids));
    }
}

package com.ruoyi.coc.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.coc.domain.CocCorporate;
import com.ruoyi.coc.domain.CocGroup;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocCorporateService;
import com.ruoyi.coc.service.ICocGroupService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

/**
 * 企业会员注册Controller
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/coc/corporate")
public class CocCorporateController extends BaseController
{
    private String prefix = "coc/corporate";

    @Autowired
    private ICocCorporateService cocCorporateService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private ICocGroupService cocGroupService;
    
    /**
     * 企业会员注册
     */
    @GetMapping("/c_register")
    public String c_register()
    {
        return prefix + "/c_register";
    }
    
    /**
     * 保存企业会员注册
     * @param cocGroup
     * @return
     */
    @Log(title = "企业会员注册", businessType = BusinessType.INSERT)
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult register(@Validated SysUser user,CocCorporate cocCorporate,Long gId)
    {
    	//保存用户
    	if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user.getLoginName())))
        {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        //用户编号
        String userCode = userService.getUserCode(null);
        String autoCode = getAutoCode(userCode);
        user.setUserCode("CU"+autoCode);
        user.setUserName(cocCorporate.getcName());
        
        //保存企业
    	//获取企业下一个编号 最大999999
    	String num = cocCorporateService.getCocCorporateCode();
    	String autoNum = getAutoCode(num);
    	cocCorporate.setcCode("C"+autoNum);//企业编号
		
		//保存用户与社团、企业、个人关系
		CocUserGcp cocUserGcp = new CocUserGcp();
		cocUserGcp.setUserCode(user.getUserCode());
		cocUserGcp.setGcpCode(cocCorporate.getcCode());
		cocUserGcp.setRoleCode("0");
		
		//保存企业或个人与团体关系表
		CocGroupCp cocGroupCp = new CocGroupCp();
		CocGroup cocGroup = cocGroupService.selectCocGroupById(gId);
		cocGroupCp.setgCode(cocGroup.getgCode());//团体编号
		cocGroupCp.setCpCode(cocCorporate.getcCode());//企业编号
		cocGroupCp.setStatus("1");//状态（0正常 1申请中 2未通过 3退团）
        return toAjax(cocCorporateService.insertCocCorporate(user, cocCorporate, cocUserGcp, cocGroupCp));
    }
    
    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    @RequiresPermissions("coc:corporate:view")
    @GetMapping()
    public String corporate()
    {
        return prefix + "/corporate";
    }

    /**
     * 查询企业会员注册列表
     */
    @RequiresPermissions("coc:corporate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CocCorporate cocCorporate)
    {
        startPage();
        List<CocCorporate> list = cocCorporateService.selectCocCorporateList(cocCorporate);
        return getDataTable(list);
    }

    /**
     * 导出企业会员注册列表
     */
    @RequiresPermissions("coc:corporate:export")
    @Log(title = "企业会员注册", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CocCorporate cocCorporate)
    {
        List<CocCorporate> list = cocCorporateService.selectCocCorporateList(cocCorporate);
        ExcelUtil<CocCorporate> util = new ExcelUtil<CocCorporate>(CocCorporate.class);
        return util.exportExcel(list, "corporate");
    }

    /**
     * 新增企业会员注册
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业会员注册
     */
    @RequiresPermissions("coc:corporate:add")
    @Log(title = "企业会员注册", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CocCorporate cocCorporate)
    {
        return toAjax(cocCorporateService.insertCocCorporate(cocCorporate));
    }

    /**
     * 修改企业会员注册
     */
    @GetMapping("/edit/{cId}")
    public String edit(@PathVariable("cId") Long cId, ModelMap mmap)
    {
        CocCorporate cocCorporate = cocCorporateService.selectCocCorporateById(cId);
        mmap.put("cocCorporate", cocCorporate);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业会员注册
     */
    @RequiresPermissions("coc:corporate:edit")
    @Log(title = "企业会员注册", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CocCorporate cocCorporate)
    {
        return toAjax(cocCorporateService.updateCocCorporate(cocCorporate));
    }

    /**
     * 删除企业会员注册
     */
    @RequiresPermissions("coc:corporate:remove")
    @Log(title = "企业会员注册", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cocCorporateService.deleteCocCorporateByIds(ids));
    }
}

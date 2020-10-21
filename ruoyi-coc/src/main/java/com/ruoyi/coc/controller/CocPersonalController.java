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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.coc.domain.CocGroup;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.domain.CocPersonal;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocGroupService;
import com.ruoyi.coc.service.ICocPersonalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人会员注册Controller
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/coc/personal")
public class CocPersonalController extends BaseController
{
    private String prefix = "coc/personal";

    @Autowired
    private ICocPersonalService cocPersonalService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private ICocGroupService cocGroupService;
    
    /**
     * 个人会员注册
     */
    @GetMapping("/p_register")
    public String p_register()
    {
        return prefix + "/p_register";
    }
    
    /**
     * 保存个人会员注册
     * @param cocGroup
     * @return
     */
    @Log(title = "个人会员注册", businessType = BusinessType.INSERT)
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult register(@Validated SysUser user,CocPersonal cocPersonal,Long gId)
    {
    	//多个保存一律放在业务方法里进行保存
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
        user.setUserCode("PU"+autoCode);
        user.setUserName(cocPersonal.getpName());
        //int insertUser = userService.insertUser(user);
        
        //保存个人会员
    	//获取个人下一个编号 最大999999
        String num = cocPersonalService.getCocPersonalCode();
    	String autoNum = getAutoCode(num);
    	cocPersonal.setpCode("P"+autoNum);//个人编号
    	//int insertCocPersonal = cocPersonalService.insertCocPersonal(cocPersonal);
		
		//保存用户与社团、企业、个人关系
		CocUserGcp cocUserGcp = new CocUserGcp();
		cocUserGcp.setUserCode(user.getUserCode());
		cocUserGcp.setGcpCode(cocPersonal.getpCode());
		cocUserGcp.setRoleCode("0");
		//int insertCocUserGcp = cocUserGcpService.insertCocUserGcp(cocUserGcp);
		
		//保存企业或个人与团体关系表
		CocGroupCp cocGroupCp = new CocGroupCp();
		CocGroup cocGroup = cocGroupService.selectCocGroupById(gId);
		cocGroupCp.setgCode(cocGroup.getgCode());//团体编号
		cocGroupCp.setCpCode(cocPersonal.getpCode());//个人编号
		cocGroupCp.setStatus("1");//状态（0正常 1申请中 2未通过 3退团）
		//int insertCocGroupCp = cocGroupCpService.insertCocGroupCp(cocGroupCp);
		
		/*if(insertUser>0 && insertCocPersonal>0 && insertCocUserGcp>0 && insertCocGroupCp>0){
			return success();
		}else{
			return error();
		}*/
        return toAjax(cocPersonalService.insertCocPersonal(user, cocPersonal, cocUserGcp, cocGroupCp));
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

    @RequiresPermissions("coc:personal:view")
    @GetMapping()
    public String personal()
    {
        return prefix + "/personal";
    }

    /**
     * 查询个人会员注册列表
     */
    @RequiresPermissions("coc:personal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CocPersonal cocPersonal)
    {
        startPage();
        List<CocPersonal> list = cocPersonalService.selectCocPersonalList(cocPersonal);
        return getDataTable(list);
    }

    /**
     * 导出个人会员注册列表
     */
    @RequiresPermissions("coc:personal:export")
    @Log(title = "个人会员注册", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CocPersonal cocPersonal)
    {
        List<CocPersonal> list = cocPersonalService.selectCocPersonalList(cocPersonal);
        ExcelUtil<CocPersonal> util = new ExcelUtil<CocPersonal>(CocPersonal.class);
        return util.exportExcel(list, "personal");
    }

    /**
     * 新增个人会员注册
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人会员注册
     */
    @RequiresPermissions("coc:personal:add")
    @Log(title = "个人会员注册", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CocPersonal cocPersonal)
    {
        return toAjax(cocPersonalService.insertCocPersonal(cocPersonal));
    }

    /**
     * 修改个人会员注册
     */
    @GetMapping("/edit/{pId}")
    public String edit(@PathVariable("pId") Long pId, ModelMap mmap)
    {
        CocPersonal cocPersonal = cocPersonalService.selectCocPersonalById(pId);
        mmap.put("cocPersonal", cocPersonal);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人会员注册
     */
    @RequiresPermissions("coc:personal:edit")
    @Log(title = "个人会员注册", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CocPersonal cocPersonal)
    {
        return toAjax(cocPersonalService.updateCocPersonal(cocPersonal));
    }

    /**
     * 删除个人会员注册
     */
    @RequiresPermissions("coc:personal:remove")
    @Log(title = "个人会员注册", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cocPersonalService.deleteCocPersonalByIds(ids));
    }
}

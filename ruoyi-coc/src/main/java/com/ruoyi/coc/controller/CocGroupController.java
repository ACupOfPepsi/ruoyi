package com.ruoyi.coc.controller;

import java.util.List;
import java.util.Map;

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
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocGroupService;
import com.ruoyi.coc.service.ICocUserGcpService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.Ztree2;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社会团体信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Controller
@RequestMapping("/coc/group")
public class CocGroupController extends BaseController
{
    private String prefix = "coc/group";

    @Autowired
    private ICocGroupService cocGroupService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysPasswordService passwordService;
    
    /**
     * 注册社会团体信息
     */
    @GetMapping("/g_register")
    public String g_register()
    {
        return prefix + "/g_register";
    }
    
    /**
     * 保存社会团体信息
     * @param cocGroup
     * @return
     */
    @Log(title = "社会团体信息", businessType = BusinessType.INSERT)
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult register(@Validated SysUser user,CocGroup cocGroup)
    {
    	//保存用户
    	if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user.getLoginName())))
        {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        }
        /*else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        }
        else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }*/
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        //user.setCreateBy(ShiroUtils.getLoginName());
        //用户编号
        String userCode = userService.getUserCode(null);
        String autoCode = getAutoCode(userCode);
        user.setUserCode("GU"+autoCode);
        user.setUserName(cocGroup.getOrganName());
        //int insertUser = userService.insertUser(user);
        
        //保存社团
    	//获取团体下一个编号 最大999999
    	String num = cocGroupService.getCocGroupCode();
    	String autoNum = getAutoCode(num);
    	cocGroup.setParentId(0L);
    	cocGroup.setAncestors("0");
		cocGroup.setgCode("G"+autoNum);//社会团体编号
		//int insertCocGroup = cocGroupService.insertCocGroup(cocGroup);
		
		//保存用户与社团、企业、个人关系
		CocUserGcp cocUserGcp = new CocUserGcp();
		cocUserGcp.setUserCode(user.getUserCode());
		cocUserGcp.setGcpCode(cocGroup.getgCode());
		cocUserGcp.setRoleCode("0");
		//int insertCocUserGcp = cocUserGcpService.insertCocUserGcp(cocUserGcp);
		
		/*if(insertUser>0 && insertCocGroup>0 && insertCocUserGcp>0){
			return success();
		}else{
			return error();
		}*/
        return toAjax(cocGroupService.insertCocGroup(user, cocGroup, cocUserGcp));
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
    
    /**
     * 获取待办事项
     * @param cocGroup
     * @return
     */
    @PostMapping("/toDo")
    @ResponseBody
    public TableDataInfo toDo(CocGroup cocGroup)
    {
        startPage();
        List<Map<String, Object>> list = cocGroupService.selectCoCToDo(null);
        return getDataTable(list);
    }
    
    /**
     * 获取社会团体tree关联数据
     * @param cocGroup
     * @return
     */
    @PostMapping("/treeInfo")
    @ResponseBody
    public TableDataInfo treeInfo(CocGroup cocGroup)
    {
        startPage();
        List<Map<String, Object>> list = cocGroupService.selectCoCInfo(null);
        return getDataTable(list);
    }

    @RequiresPermissions("coc:group:view")
    @GetMapping()
    public String group()
    {
        return prefix + "/group";
    }

    /**
     * 查询社会团体信息列表
     */
    @RequiresPermissions("coc:group:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CocGroup cocGroup)
    {
        startPage();
        List<CocGroup> list = cocGroupService.selectCocGroupList(cocGroup);
        return getDataTable(list);
    }

    /**
     * 导出社会团体信息列表
     */
    @RequiresPermissions("coc:group:export")
    @Log(title = "社会团体信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CocGroup cocGroup)
    {
        List<CocGroup> list = cocGroupService.selectCocGroupList(cocGroup);
        ExcelUtil<CocGroup> util = new ExcelUtil<CocGroup>(CocGroup.class);
        return util.exportExcel(list, "group");
    }

    /**
     * 新增社会团体信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社会团体信息
     */
    @RequiresPermissions("coc:group:add")
    @Log(title = "社会团体信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CocGroup cocGroup)
    {
    	cocGroup.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(cocGroupService.insertCocGroup(cocGroup));
    }

    /**
     * 修改社会团体信息
     */
    @GetMapping("/edit/{gId}")
    public String edit(@PathVariable("gId") Long gId, ModelMap mmap)
    {
        CocGroup cocGroup = cocGroupService.selectCocGroupById(gId);
        mmap.put("cocGroup", cocGroup);
        return prefix + "/edit";
    }

    /**
     * 修改保存社会团体信息
     */
    @RequiresPermissions("coc:group:edit")
    @Log(title = "社会团体信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CocGroup cocGroup)
    {
        return toAjax(cocGroupService.updateCocGroup(cocGroup));
    }

    /**
     * 删除社会团体信息
     */
    @RequiresPermissions("coc:group:remove")
    @Log(title = "社会团体信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cocGroupService.deleteCocGroupByIds(ids));
    }
    /**
     * 选择社会团体信息树
     */
    @GetMapping(value = { "/selectGroupTree/{gId}", "/selectGroupTree/" })
    public String selectGroupTree(@PathVariable(value = "gId", required = false) Long gId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(gId))
        {
            mmap.put("cocGroup", cocGroupService.selectCocGroupById(gId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载社会团体信息树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = cocGroupService.selectCocGroupTree();
        return ztrees;
    }
    
    /**
     * 加载社会团体及下级信息树列表
     */
    @GetMapping("/tree2Data")
    @ResponseBody
    public List<Ztree2> tree2Data()
    {
        List<Ztree2> ztrees = cocGroupService.selectCoCTree();
        return ztrees;
    }
}

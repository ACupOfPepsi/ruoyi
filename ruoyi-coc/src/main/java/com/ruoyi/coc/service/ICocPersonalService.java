package com.ruoyi.coc.service;

import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.domain.CocPersonal;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.system.domain.SysUser;

import java.util.List;

/**
 * 个人会员注册Service接口
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public interface ICocPersonalService 
{
    /**
     * 查询个人会员注册
     * 
     * @param pId 个人会员注册ID
     * @return 个人会员注册
     */
    public CocPersonal selectCocPersonalById(Long pId);

    /**
     * 查询个人会员注册列表
     * 
     * @param cocPersonal 个人会员注册
     * @return 个人会员注册集合
     */
    public List<CocPersonal> selectCocPersonalList(CocPersonal cocPersonal);

    /**
     * 获取个人会员下一个编号
     * @return
     */
    public String getCocPersonalCode();
    
    /**
     * 新增个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    public int insertCocPersonal(CocPersonal cocPersonal);
    
    /**
     * 新增个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    public int insertCocPersonal(SysUser user,CocPersonal cocPersonal,CocUserGcp cocUserGcp,CocGroupCp cocGroupCp);

    /**
     * 修改个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    public int updateCocPersonal(CocPersonal cocPersonal);

    /**
     * 批量删除个人会员注册
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocPersonalByIds(String ids);

    /**
     * 删除个人会员注册信息
     * 
     * @param pId 个人会员注册ID
     * @return 结果
     */
    public int deleteCocPersonalById(Long pId);
}

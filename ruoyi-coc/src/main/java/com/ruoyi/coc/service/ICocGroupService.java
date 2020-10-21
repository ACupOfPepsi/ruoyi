package com.ruoyi.coc.service;

import com.ruoyi.coc.domain.CocGroup;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.Ztree2;
import com.ruoyi.system.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 社会团体信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public interface ICocGroupService 
{
    /**
     * 查询社会团体信息
     * 
     * @param gId 社会团体信息ID
     * @return 社会团体信息
     */
    public CocGroup selectCocGroupById(Long gId);

    /**
     * 查询社会团体信息列表
     * 
     * @param cocGroup 社会团体信息
     * @return 社会团体信息集合
     */
    public List<CocGroup> selectCocGroupList(CocGroup cocGroup);

    /**
     * 获取团体下一个编号
     * @return
     */
    public String getCocGroupCode();
    
    /**
     * 获取待办事项
     * @param params
     * @return
     */
    public List<Map<String,Object>> selectCoCToDo(String params);
    
    /**
     * 获取社会团体tree关联数据
     * @param params
     * @return
     */
    public List<Map<String,Object>> selectCoCInfo(String params);
    
    /**
     * 新增社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    public int insertCocGroup(CocGroup cocGroup);
    
    /**
     * 新增社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    public int insertCocGroup(SysUser user,CocGroup cocGroup,CocUserGcp cocUserGcp);

    /**
     * 修改社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    public int updateCocGroup(CocGroup cocGroup);

    /**
     * 批量删除社会团体信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocGroupByIds(String ids);

    /**
     * 删除社会团体信息信息
     * 
     * @param gId 社会团体信息ID
     * @return 结果
     */
    public int deleteCocGroupById(Long gId);
    
    /**
     * 查询社会团体信息树列表
     * 
     * @return 所有社会团体信息信息
     */
    public List<Ztree> selectCocGroupTree();
    
    /**
     * 查询社会团体及所属下级树列表
     * 
     * @return 所有社会团体及所属下级信息
     */
    public List<Ztree2> selectCoCTree();
}

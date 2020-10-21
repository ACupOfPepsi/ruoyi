package com.ruoyi.coc.mapper;

import com.ruoyi.coc.domain.CocGroup;
import java.util.List;
import java.util.Map;

/**
 * 社会团体信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public interface CocGroupMapper 
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
     * 获取社会团体及所有下级组织机构
     * @param params
     * @return
     */
    public List<Map<String,Object>> selectCoCTree(String params);
    
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
     * 修改社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    public int updateCocGroup(CocGroup cocGroup);

    /**
     * 删除社会团体信息
     * 
     * @param gId 社会团体信息ID
     * @return 结果
     */
    public int deleteCocGroupById(Long gId);

    /**
     * 批量删除社会团体信息
     * 
     * @param gIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocGroupByIds(String[] gIds);
}

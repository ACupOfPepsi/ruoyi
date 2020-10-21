package com.ruoyi.coc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coc.mapper.CocGroupMapper;
import com.ruoyi.coc.mapper.CocUserGcpMapper;
import com.ruoyi.coc.domain.CocGroup;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocGroupService;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.Ztree2;
import com.ruoyi.common.core.text.Convert;

/**
 * 社会团体信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Service
public class CocGroupServiceImpl implements ICocGroupService 
{
    @Autowired
    private CocGroupMapper cocGroupMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CocUserGcpMapper cocUserGcpMapper;

    /**
     * 查询社会团体信息
     * 
     * @param gId 社会团体信息ID
     * @return 社会团体信息
     */
    @Override
    public CocGroup selectCocGroupById(Long gId)
    {
        return cocGroupMapper.selectCocGroupById(gId);
    }

    /**
     * 查询社会团体信息列表
     * 
     * @param cocGroup 社会团体信息
     * @return 社会团体信息
     */
    @Override
    public List<CocGroup> selectCocGroupList(CocGroup cocGroup)
    {
        return cocGroupMapper.selectCocGroupList(cocGroup);
    }

    @Override
	public String getCocGroupCode() {
		return cocGroupMapper.getCocGroupCode();
	}
    
	@Override
	public List<Map<String, Object>> selectCoCToDo(String params) {
		return cocGroupMapper.selectCoCToDo(params);
	}
    
    /**
     * 新增社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    @Override
    public int insertCocGroup(CocGroup cocGroup)
    {
        cocGroup.setCreateTime(DateUtils.getNowDate());
        return cocGroupMapper.insertCocGroup(cocGroup);
    }
    
    /**
     * 新增社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    @Override
    public int insertCocGroup(SysUser user,CocGroup cocGroup,CocUserGcp cocUserGcp)
    {
    	userMapper.insertUser(user);
        cocUserGcpMapper.insertCocUserGcp(cocUserGcp);
        cocGroup.setCreateTime(DateUtils.getNowDate());
        return cocGroupMapper.insertCocGroup(cocGroup);
    }

    /**
     * 修改社会团体信息
     * 
     * @param cocGroup 社会团体信息
     * @return 结果
     */
    @Override
    public int updateCocGroup(CocGroup cocGroup)
    {
        cocGroup.setUpdateTime(DateUtils.getNowDate());
        return cocGroupMapper.updateCocGroup(cocGroup);
    }

    /**
     * 删除社会团体信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCocGroupByIds(String ids)
    {
        return cocGroupMapper.deleteCocGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社会团体信息信息
     * 
     * @param gId 社会团体信息ID
     * @return 结果
     */
    @Override
    public int deleteCocGroupById(Long gId)
    {
        return cocGroupMapper.deleteCocGroupById(gId);
    }
    /**
     * 查询社会团体信息树列表
     * 
     * @return 所有社会团体信息信息
     */
    @Override
    public List<Ztree> selectCocGroupTree()
    {
        List<CocGroup> cocGroupList = cocGroupMapper.selectCocGroupList(new CocGroup());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (CocGroup cocGroup : cocGroupList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(cocGroup.getgId());
            ztree.setpId(cocGroup.getParentId());
            ztree.setName(cocGroup.getOrganName());
            ztree.setTitle(cocGroup.getOrganName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

	@Override
	public List<Ztree2> selectCoCTree() {
		List<Map<String,Object>> selectCoCTree = cocGroupMapper.selectCoCTree(null);
        List<Ztree2> ztrees = new ArrayList<Ztree2>();
        for (Map<String,Object> group : selectCoCTree)
        {
            Ztree2 ztree = new Ztree2();
           // group.get("code")!=null?group.get("code").toString():"";
            ztree.setId(group.get("code")!=null?group.get("code").toString():"");
            ztree.setpId(group.get("g_code")!=null?group.get("g_code").toString():"");
            ztree.setName(group.get("name")!=null?group.get("name").toString():"");
            ztree.setTitle(group.get("name")!=null?group.get("name").toString():"");
            ztrees.add(ztree);
        }
        return ztrees;
	}

	@Override
	public List<Map<String, Object>> selectCoCInfo(String params) {
		return cocGroupMapper.selectCoCInfo(params);
	}
}

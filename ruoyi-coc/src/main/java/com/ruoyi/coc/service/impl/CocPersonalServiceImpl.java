package com.ruoyi.coc.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.coc.mapper.CocGroupCpMapper;
import com.ruoyi.coc.mapper.CocPersonalMapper;
import com.ruoyi.coc.mapper.CocUserGcpMapper;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.domain.CocPersonal;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocPersonalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 个人会员注册Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Service
public class CocPersonalServiceImpl implements ICocPersonalService 
{
    @Autowired
    private CocPersonalMapper cocPersonalMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CocUserGcpMapper cocUserGcpMapper;
    @Autowired
    private CocGroupCpMapper cocGroupCpMapper;

    /**
     * 查询个人会员注册
     * 
     * @param pId 个人会员注册ID
     * @return 个人会员注册
     */
    @Override
    public CocPersonal selectCocPersonalById(Long pId)
    {
        return cocPersonalMapper.selectCocPersonalById(pId);
    }

    /**
     * 查询个人会员注册列表
     * 
     * @param cocPersonal 个人会员注册
     * @return 个人会员注册
     */
    @Override
    public List<CocPersonal> selectCocPersonalList(CocPersonal cocPersonal)
    {
        return cocPersonalMapper.selectCocPersonalList(cocPersonal);
    }
    
    /**
     * 获取个人会员下一个编号
     */
	@Override
	public String getCocPersonalCode() {
		return cocPersonalMapper.getCocPersonalCode();
	}
	
	/**
     * 新增个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    @Override
    public int insertCocPersonal(CocPersonal cocPersonal)
    {
        return cocPersonalMapper.insertCocPersonal(cocPersonal);
    }

    /**
     * 新增个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    @Override
    public int insertCocPersonal(SysUser user,CocPersonal cocPersonal,CocUserGcp cocUserGcp,CocGroupCp cocGroupCp)
    {
    	userMapper.insertUser(user);
        cocUserGcpMapper.insertCocUserGcp(cocUserGcp);
        cocGroupCpMapper.insertCocGroupCp(cocGroupCp);
        cocPersonal.setCreateTime(DateUtils.getNowDate());
        return cocPersonalMapper.insertCocPersonal(cocPersonal);
    }

    /**
     * 修改个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    @Override
    public int updateCocPersonal(CocPersonal cocPersonal)
    {
        cocPersonal.setUpdateTime(DateUtils.getNowDate());
        return cocPersonalMapper.updateCocPersonal(cocPersonal);
    }

    /**
     * 删除个人会员注册对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCocPersonalByIds(String ids)
    {
        return cocPersonalMapper.deleteCocPersonalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人会员注册信息
     * 
     * @param pId 个人会员注册ID
     * @return 结果
     */
    @Override
    public int deleteCocPersonalById(Long pId)
    {
        return cocPersonalMapper.deleteCocPersonalById(pId);
    }
}

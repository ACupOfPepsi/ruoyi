package com.ruoyi.coc.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coc.mapper.CocCorporateMapper;
import com.ruoyi.coc.mapper.CocGroupCpMapper;
import com.ruoyi.coc.mapper.CocUserGcpMapper;
import com.ruoyi.coc.domain.CocCorporate;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocCorporateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业会员注册Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Service
public class CocCorporateServiceImpl implements ICocCorporateService 
{
    @Autowired
    private CocCorporateMapper cocCorporateMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CocUserGcpMapper cocUserGcpMapper;
    @Autowired
    private CocGroupCpMapper cocGroupCpMapper;

    /**
     * 查询企业会员注册
     * 
     * @param cId 企业会员注册ID
     * @return 企业会员注册
     */
    @Override
    public CocCorporate selectCocCorporateById(Long cId)
    {
        return cocCorporateMapper.selectCocCorporateById(cId);
    }

    /**
     * 查询企业会员注册列表
     * 
     * @param cocCorporate 企业会员注册
     * @return 企业会员注册
     */
    @Override
    public List<CocCorporate> selectCocCorporateList(CocCorporate cocCorporate)
    {
        return cocCorporateMapper.selectCocCorporateList(cocCorporate);
    }
    
    @Override
	public String getCocCorporateCode() {
		return cocCorporateMapper.getCocCorporateCode();
	}

    /**
     * 新增企业会员注册
     * 
     * @param cocCorporate 企业会员注册
     * @return 结果
     */
    @Override
    public int insertCocCorporate(CocCorporate cocCorporate)
    {
        cocCorporate.setCreateTime(DateUtils.getNowDate());
        return cocCorporateMapper.insertCocCorporate(cocCorporate);
    }
    
    /**
     * 新增企业会员注册
     * 
     * @param cocCorporate 企业会员注册
     * @return 结果
     */
    @Override
    public int insertCocCorporate(SysUser user,CocCorporate cocCorporate,CocUserGcp cocUserGcp,CocGroupCp cocGroupCp)
    {
    	userMapper.insertUser(user);
        cocUserGcpMapper.insertCocUserGcp(cocUserGcp);
        cocGroupCpMapper.insertCocGroupCp(cocGroupCp);
        cocCorporate.setCreateTime(DateUtils.getNowDate());
        return cocCorporateMapper.insertCocCorporate(cocCorporate);
    }


    /**
     * 修改企业会员注册
     * 
     * @param cocCorporate 企业会员注册
     * @return 结果
     */
    @Override
    public int updateCocCorporate(CocCorporate cocCorporate)
    {
        cocCorporate.setUpdateTime(DateUtils.getNowDate());
        return cocCorporateMapper.updateCocCorporate(cocCorporate);
    }

    /**
     * 删除企业会员注册对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCocCorporateByIds(String ids)
    {
        return cocCorporateMapper.deleteCocCorporateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业会员注册信息
     * 
     * @param cId 企业会员注册ID
     * @return 结果
     */
    @Override
    public int deleteCocCorporateById(Long cId)
    {
        return cocCorporateMapper.deleteCocCorporateById(cId);
    }
}

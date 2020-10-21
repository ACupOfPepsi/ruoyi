package com.ruoyi.coc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coc.mapper.CocUserGcpMapper;
import com.ruoyi.coc.domain.CocUserGcp;
import com.ruoyi.coc.service.ICocUserGcpService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户与社团、企业、个人关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Service
public class CocUserGcpServiceImpl implements ICocUserGcpService 
{
    @Autowired
    private CocUserGcpMapper cocUserGcpMapper;

    /**
     * 查询用户与社团、企业、个人关系
     * 
     * @param userId 用户与社团、企业、个人关系ID
     * @return 用户与社团、企业、个人关系
     */
    @Override
    public CocUserGcp selectCocUserGcpById(Long userId)
    {
        return cocUserGcpMapper.selectCocUserGcpById(userId);
    }

    /**
     * 查询用户与社团、企业、个人关系列表
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 用户与社团、企业、个人关系
     */
    @Override
    public List<CocUserGcp> selectCocUserGcpList(CocUserGcp cocUserGcp)
    {
        return cocUserGcpMapper.selectCocUserGcpList(cocUserGcp);
    }

    /**
     * 新增用户与社团、企业、个人关系
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 结果
     */
    @Override
    public int insertCocUserGcp(CocUserGcp cocUserGcp)
    {
        return cocUserGcpMapper.insertCocUserGcp(cocUserGcp);
    }

    /**
     * 修改用户与社团、企业、个人关系
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 结果
     */
    @Override
    public int updateCocUserGcp(CocUserGcp cocUserGcp)
    {
        return cocUserGcpMapper.updateCocUserGcp(cocUserGcp);
    }

    /**
     * 删除用户与社团、企业、个人关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCocUserGcpByIds(String ids)
    {
        return cocUserGcpMapper.deleteCocUserGcpByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户与社团、企业、个人关系信息
     * 
     * @param userId 用户与社团、企业、个人关系ID
     * @return 结果
     */
    @Override
    public int deleteCocUserGcpById(Long userId)
    {
        return cocUserGcpMapper.deleteCocUserGcpById(userId);
    }
}

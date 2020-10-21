package com.ruoyi.coc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coc.mapper.CocGroupCpMapper;
import com.ruoyi.coc.domain.CocGroupCp;
import com.ruoyi.coc.service.ICocGroupCpService;
import com.ruoyi.common.core.text.Convert;

/**
 * 团体与企业或个人关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
@Service
public class CocGroupCpServiceImpl implements ICocGroupCpService 
{
    @Autowired
    private CocGroupCpMapper cocGroupCpMapper;

    /**
     * 查询团体与企业或个人关系
     * 
     * @param gCode 团体与企业或个人关系ID
     * @return 团体与企业或个人关系
     */
    @Override
    public CocGroupCp selectCocGroupCpById(String gCode)
    {
        return cocGroupCpMapper.selectCocGroupCpById(gCode);
    }

    /**
     * 查询团体与企业或个人关系列表
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 团体与企业或个人关系
     */
    @Override
    public List<CocGroupCp> selectCocGroupCpList(CocGroupCp cocGroupCp)
    {
        return cocGroupCpMapper.selectCocGroupCpList(cocGroupCp);
    }

    /**
     * 新增团体与企业或个人关系
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 结果
     */
    @Override
    public int insertCocGroupCp(CocGroupCp cocGroupCp)
    {
        return cocGroupCpMapper.insertCocGroupCp(cocGroupCp);
    }

    /**
     * 修改团体与企业或个人关系
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 结果
     */
    @Override
    public int updateCocGroupCp(CocGroupCp cocGroupCp)
    {
        return cocGroupCpMapper.updateCocGroupCp(cocGroupCp);
    }

    /**
     * 删除团体与企业或个人关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCocGroupCpByIds(String ids)
    {
        return cocGroupCpMapper.deleteCocGroupCpByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除团体与企业或个人关系信息
     * 
     * @param gCode 团体与企业或个人关系ID
     * @return 结果
     */
    @Override
    public int deleteCocGroupCpById(String gCode)
    {
        return cocGroupCpMapper.deleteCocGroupCpById(gCode);
    }
}

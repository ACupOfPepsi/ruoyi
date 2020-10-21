package com.ruoyi.coc.service;

import com.ruoyi.coc.domain.CocUserGcp;
import java.util.List;

/**
 * 用户与社团、企业、个人关系Service接口
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public interface ICocUserGcpService 
{
    /**
     * 查询用户与社团、企业、个人关系
     * 
     * @param userId 用户与社团、企业、个人关系ID
     * @return 用户与社团、企业、个人关系
     */
    public CocUserGcp selectCocUserGcpById(Long userId);

    /**
     * 查询用户与社团、企业、个人关系列表
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 用户与社团、企业、个人关系集合
     */
    public List<CocUserGcp> selectCocUserGcpList(CocUserGcp cocUserGcp);

    /**
     * 新增用户与社团、企业、个人关系
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 结果
     */
    public int insertCocUserGcp(CocUserGcp cocUserGcp);

    /**
     * 修改用户与社团、企业、个人关系
     * 
     * @param cocUserGcp 用户与社团、企业、个人关系
     * @return 结果
     */
    public int updateCocUserGcp(CocUserGcp cocUserGcp);

    /**
     * 批量删除用户与社团、企业、个人关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocUserGcpByIds(String ids);

    /**
     * 删除用户与社团、企业、个人关系信息
     * 
     * @param userId 用户与社团、企业、个人关系ID
     * @return 结果
     */
    public int deleteCocUserGcpById(Long userId);
}

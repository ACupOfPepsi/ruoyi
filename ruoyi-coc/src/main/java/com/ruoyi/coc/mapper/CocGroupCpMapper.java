package com.ruoyi.coc.mapper;

import com.ruoyi.coc.domain.CocGroupCp;
import java.util.List;

/**
 * 团体与企业或个人关系Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public interface CocGroupCpMapper 
{
    /**
     * 查询团体与企业或个人关系
     * 
     * @param gCode 团体与企业或个人关系ID
     * @return 团体与企业或个人关系
     */
    public CocGroupCp selectCocGroupCpById(String gCode);

    /**
     * 查询团体与企业或个人关系列表
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 团体与企业或个人关系集合
     */
    public List<CocGroupCp> selectCocGroupCpList(CocGroupCp cocGroupCp);

    /**
     * 新增团体与企业或个人关系
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 结果
     */
    public int insertCocGroupCp(CocGroupCp cocGroupCp);

    /**
     * 修改团体与企业或个人关系
     * 
     * @param cocGroupCp 团体与企业或个人关系
     * @return 结果
     */
    public int updateCocGroupCp(CocGroupCp cocGroupCp);

    /**
     * 删除团体与企业或个人关系
     * 
     * @param gCode 团体与企业或个人关系ID
     * @return 结果
     */
    public int deleteCocGroupCpById(String gCode);

    /**
     * 批量删除团体与企业或个人关系
     * 
     * @param gCodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocGroupCpByIds(String[] gCodes);
}

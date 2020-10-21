package com.ruoyi.coc.mapper;

import com.ruoyi.coc.domain.CocCorporate;
import java.util.List;

/**
 * 企业会员注册Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public interface CocCorporateMapper 
{
    /**
     * 查询企业会员注册
     * 
     * @param cId 企业会员注册ID
     * @return 企业会员注册
     */
    public CocCorporate selectCocCorporateById(Long cId);

    /**
     * 查询企业会员注册列表
     * 
     * @param cocCorporate 企业会员注册
     * @return 企业会员注册集合
     */
    public List<CocCorporate> selectCocCorporateList(CocCorporate cocCorporate);

    /**
     * 获取企业下一个编号
     * @return
     */
    public String getCocCorporateCode();
    
    /**
     * 新增企业会员注册
     * 
     * @param cocCorporate 企业会员注册
     * @return 结果
     */
    public int insertCocCorporate(CocCorporate cocCorporate);

    /**
     * 修改企业会员注册
     * 
     * @param cocCorporate 企业会员注册
     * @return 结果
     */
    public int updateCocCorporate(CocCorporate cocCorporate);

    /**
     * 删除企业会员注册
     * 
     * @param cId 企业会员注册ID
     * @return 结果
     */
    public int deleteCocCorporateById(Long cId);

    /**
     * 批量删除企业会员注册
     * 
     * @param cIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocCorporateByIds(String[] cIds);
}

package com.ruoyi.coc.mapper;

import com.ruoyi.coc.domain.CocPersonal;
import java.util.List;

/**
 * 个人会员注册Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public interface CocPersonalMapper 
{
    /**
     * 查询个人会员注册
     * 
     * @param pId 个人会员注册ID
     * @return 个人会员注册
     */
    public CocPersonal selectCocPersonalById(Long pId);

    /**
     * 查询个人会员注册列表
     * 
     * @param cocPersonal 个人会员注册
     * @return 个人会员注册集合
     */
    public List<CocPersonal> selectCocPersonalList(CocPersonal cocPersonal);

    /**
     * 获取个人会员下一个编号
     * @return
     */
    public String getCocPersonalCode();
    
    /**
     * 新增个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    public int insertCocPersonal(CocPersonal cocPersonal);

    /**
     * 修改个人会员注册
     * 
     * @param cocPersonal 个人会员注册
     * @return 结果
     */
    public int updateCocPersonal(CocPersonal cocPersonal);

    /**
     * 删除个人会员注册
     * 
     * @param pId 个人会员注册ID
     * @return 结果
     */
    public int deleteCocPersonalById(Long pId);

    /**
     * 批量删除个人会员注册
     * 
     * @param pIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCocPersonalByIds(String[] pIds);
}

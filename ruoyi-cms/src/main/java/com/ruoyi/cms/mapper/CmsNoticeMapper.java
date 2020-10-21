package com.ruoyi.cms.mapper;

import com.ruoyi.cms.domain.CmsNotice;
import java.util.List;

/**
 * 公告信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
public interface CmsNoticeMapper 
{
    /**
     * 查询公告信息
     * 
     * @param id 公告信息ID
     * @return 公告信息
     */
    public CmsNotice selectCmsNoticeById(String id);

    /**
     * 查询公告信息列表
     * 
     * @param cmsNotice 公告信息
     * @return 公告信息集合
     */
    public List<CmsNotice> selectCmsNoticeList(CmsNotice cmsNotice);

    /**
     * 新增公告信息
     * 
     * @param cmsNotice 公告信息
     * @return 结果
     */
    public int insertCmsNotice(CmsNotice cmsNotice);

    /**
     * 修改公告信息
     * 
     * @param cmsNotice 公告信息
     * @return 结果
     */
    public int updateCmsNotice(CmsNotice cmsNotice);

    /**
     * 删除公告信息
     * 
     * @param id 公告信息ID
     * @return 结果
     */
    public int deleteCmsNoticeById(String id);

    /**
     * 批量删除公告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsNoticeByIds(String[] ids);
}

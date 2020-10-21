package com.ruoyi.cms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cms.mapper.CmsNoticeMapper;
import com.ruoyi.cms.domain.CmsNotice;
import com.ruoyi.cms.service.ICmsNoticeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公告信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@Service
public class CmsNoticeServiceImpl implements ICmsNoticeService 
{
    @Autowired
    private CmsNoticeMapper cmsNoticeMapper;

    /**
     * 查询公告信息
     * 
     * @param id 公告信息ID
     * @return 公告信息
     */
    @Override
    public CmsNotice selectCmsNoticeById(String id)
    {
        return cmsNoticeMapper.selectCmsNoticeById(id);
    }

    /**
     * 查询公告信息列表
     * 
     * @param cmsNotice 公告信息
     * @return 公告信息
     */
    @Override
    public List<CmsNotice> selectCmsNoticeList(CmsNotice cmsNotice)
    {
        return cmsNoticeMapper.selectCmsNoticeList(cmsNotice);
    }

    /**
     * 新增公告信息
     * 
     * @param cmsNotice 公告信息
     * @return 结果
     */
    @Override
    public int insertCmsNotice(CmsNotice cmsNotice)
    {
        cmsNotice.setCreateTime(DateUtils.getNowDate());
        return cmsNoticeMapper.insertCmsNotice(cmsNotice);
    }

    /**
     * 修改公告信息
     * 
     * @param cmsNotice 公告信息
     * @return 结果
     */
    @Override
    public int updateCmsNotice(CmsNotice cmsNotice)
    {
        cmsNotice.setUpdateTime(DateUtils.getNowDate());
        return cmsNoticeMapper.updateCmsNotice(cmsNotice);
    }

    /**
     * 删除公告信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsNoticeByIds(String ids)
    {
        return cmsNoticeMapper.deleteCmsNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公告信息信息
     * 
     * @param id 公告信息ID
     * @return 结果
     */
    @Override
    public int deleteCmsNoticeById(String id)
    {
        return cmsNoticeMapper.deleteCmsNoticeById(id);
    }
}

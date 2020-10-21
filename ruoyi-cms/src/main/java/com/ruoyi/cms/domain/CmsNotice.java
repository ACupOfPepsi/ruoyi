package com.ruoyi.cms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 公告信息对象 cms_notice
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
public class CmsNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，公告ID */
    private String id;

    /** 作者 */
    @Excel(name = "作者")
    private String yhid;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 标签 */
    @Excel(name = "标签")
    private String tags;

    /** 状态标志 */
    @Excel(name = "状态标志")
    private Integer available;

    /** 删除标志 */
    @Excel(name = "删除标志")
    private Integer deleted;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setYhid(String yhid) 
    {
        this.yhid = yhid;
    }

    public String getYhid() 
    {
        return yhid;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTags(String tags) 
    {
        this.tags = tags;
    }

    public String getTags() 
    {
        return tags;
    }
    public void setAvailable(Integer available) 
    {
        this.available = available;
    }

    public Integer getAvailable() 
    {
        return available;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yhid", getYhid())
            .append("publishTime", getPublishTime())
            .append("title", getTitle())
            .append("tags", getTags())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("available", getAvailable())
            .append("deleted", getDeleted())
            .toString();
    }
}

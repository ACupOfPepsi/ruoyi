package com.ruoyi.coc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团体与企业或个人关系对象 coc_group_cp
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public class CocGroupCp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社会团体编号 */
    @Excel(name = "社会团体编号")
    private String gCode;

    /** 企业或个人编号 */
    @Excel(name = "企业或个人编号")
    private String cpCode;

    /** 状态（0正常 1申请中 2未通过 3退团） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=申请中,2=未通过,3=退团")
    private String status;

    public void setgCode(String gCode) 
    {
        this.gCode = gCode;
    }

    public String getgCode() 
    {
        return gCode;
    }
    public void setCpCode(String cpCode) 
    {
        this.cpCode = cpCode;
    }

    public String getCpCode() 
    {
        return cpCode;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gCode", getgCode())
            .append("cpCode", getCpCode())
            .append("status", getStatus())
            .toString();
    }
}

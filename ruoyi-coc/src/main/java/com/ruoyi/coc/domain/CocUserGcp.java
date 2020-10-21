package com.ruoyi.coc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户与社团、企业、个人关系对象 coc_user_gcp
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public class CocUserGcp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private String userCode;

    /** 社团、企业或个人编号 */
    @Excel(name = "社团、企业或个人编号")
    private String gcpCode;

    /** 角色（系统管理员 */
    @Excel(name = "角色", readConverterExp = "角色（系统管理员")
    private String roleCode;

    public void setUserCode(String userCode) 
    {
        this.userCode = userCode;
    }

    public String getUserCode() 
    {
        return userCode;
    }
    public void setGcpCode(String gcpCode) 
    {
        this.gcpCode = gcpCode;
    }

    public String getGcpCode() 
    {
        return gcpCode;
    }
    public void setRoleCode(String roleCode) 
    {
        this.roleCode = roleCode;
    }

    public String getRoleCode() 
    {
        return roleCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userCode", getUserCode())
            .append("gcpCode", getGcpCode())
            .append("roleCode", getRoleCode())
            .toString();
    }
}

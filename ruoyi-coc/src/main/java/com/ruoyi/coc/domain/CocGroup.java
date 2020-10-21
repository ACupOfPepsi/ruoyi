package com.ruoyi.coc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 社会团体信息对象 coc_group
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public class CocGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社会团体ID */
    private Long gId;
    
    /** 父团体ID */
    private Long parentId;

    /** 祖级列表 */
    private String ancestors;

    /** 社会团体编号 */
    @Excel(name = "社会团体编号")
    private String gCode;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String organName;

    /** 团体性质 */
    @Excel(name = "团体性质")
    private String groupNature;

    /** 业务范围 */
    @Excel(name = "业务范围")
    private String businessRange;

    /** 注册地址 */
    @Excel(name = "注册地址")
    private String registerAddress;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String gUscd;

    /** 有效日期 */
    @Excel(name = "有效日期")
    private String effectiveDate;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String legalReferee;

    /** 活动区域 */
    @Excel(name = "活动区域")
    private String actionArea;

    /** 注册资金 */
    @Excel(name = "注册资金")
    private String registerCapital;

    /** 业务主管单位 */
    @Excel(name = "业务主管单位")
    private String businessUnit;

    /** 发证机关 */
    @Excel(name = "发证机关")
    private String issueOffice;

    /** 发证日期 */
    @Excel(name = "发证日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issueDate;

    /** 官网地址 */
    @Excel(name = "官网地址")
    private String officialAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    /** 传真 */
    @Excel(name = "传真")
    private String fax;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mailbox;

    /** 状态（0正常 1注销 2撤销） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=注销,2=撤销")
    private String status;

    /** 团体负责人 */
    @Excel(name = "团体负责人")
    private String groupLeader;

    /** 负责人简介 */
    @Excel(name = "负责人简介")
    private String leaderProfile;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String leaderTel;

    /** 负责人邮箱 */
    @Excel(name = "负责人邮箱")
    private String leaderEmail;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setgId(Long gId) 
    {
        this.gId = gId;
    }

    public Long getgId() 
    {
        return gId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }
    public Long getParentId()
    {
        return parentId;
    }
    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }
    public String getAncestors()
    {
        return ancestors;
    }

    public void setgCode(String gCode) 
    {
        this.gCode = gCode;
    }

    public String getgCode() 
    {
        return gCode;
    }
    public void setOrganName(String organName) 
    {
        this.organName = organName;
    }

    public String getOrganName() 
    {
        return organName;
    }
    public void setGroupNature(String groupNature) 
    {
        this.groupNature = groupNature;
    }

    public String getGroupNature() 
    {
        return groupNature;
    }
    public void setBusinessRange(String businessRange) 
    {
        this.businessRange = businessRange;
    }

    public String getBusinessRange() 
    {
        return businessRange;
    }
    public void setRegisterAddress(String registerAddress) 
    {
        this.registerAddress = registerAddress;
    }

    public String getRegisterAddress() 
    {
        return registerAddress;
    }
    public void setgUscd(String gUscd) 
    {
        this.gUscd = gUscd;
    }

    public String getgUscd() 
    {
        return gUscd;
    }
    public void setEffectiveDate(String effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveDate() 
    {
        return effectiveDate;
    }
    public void setLegalReferee(String legalReferee) 
    {
        this.legalReferee = legalReferee;
    }

    public String getLegalReferee() 
    {
        return legalReferee;
    }
    public void setActionArea(String actionArea) 
    {
        this.actionArea = actionArea;
    }

    public String getActionArea() 
    {
        return actionArea;
    }
    public void setRegisterCapital(String registerCapital) 
    {
        this.registerCapital = registerCapital;
    }

    public String getRegisterCapital() 
    {
        return registerCapital;
    }
    public void setBusinessUnit(String businessUnit) 
    {
        this.businessUnit = businessUnit;
    }

    public String getBusinessUnit() 
    {
        return businessUnit;
    }
    public void setIssueOffice(String issueOffice) 
    {
        this.issueOffice = issueOffice;
    }

    public String getIssueOffice() 
    {
        return issueOffice;
    }
    public void setIssueDate(Date issueDate) 
    {
        this.issueDate = issueDate;
    }

    public Date getIssueDate() 
    {
        return issueDate;
    }
    public void setOfficialAddress(String officialAddress) 
    {
        this.officialAddress = officialAddress;
    }

    public String getOfficialAddress() 
    {
        return officialAddress;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getFax() 
    {
        return fax;
    }
    public void setMailbox(String mailbox) 
    {
        this.mailbox = mailbox;
    }

    public String getMailbox() 
    {
        return mailbox;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setGroupLeader(String groupLeader) 
    {
        this.groupLeader = groupLeader;
    }

    public String getGroupLeader() 
    {
        return groupLeader;
    }
    public void setLeaderProfile(String leaderProfile) 
    {
        this.leaderProfile = leaderProfile;
    }

    public String getLeaderProfile() 
    {
        return leaderProfile;
    }
    public void setLeaderTel(String leaderTel) 
    {
        this.leaderTel = leaderTel;
    }

    public String getLeaderTel() 
    {
        return leaderTel;
    }
    public void setLeaderEmail(String leaderEmail) 
    {
        this.leaderEmail = leaderEmail;
    }

    public String getLeaderEmail() 
    {
        return leaderEmail;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gId", getgId())
            .append("gCode", getgCode())
            .append("organName", getOrganName())
            .append("groupNature", getGroupNature())
            .append("businessRange", getBusinessRange())
            .append("registerAddress", getRegisterAddress())
            .append("gUscd", getgUscd())
            .append("effectiveDate", getEffectiveDate())
            .append("legalReferee", getLegalReferee())
            .append("actionArea", getActionArea())
            .append("registerCapital", getRegisterCapital())
            .append("businessUnit", getBusinessUnit())
            .append("issueOffice", getIssueOffice())
            .append("issueDate", getIssueDate())
            .append("officialAddress", getOfficialAddress())
            .append("telephone", getTelephone())
            .append("fax", getFax())
            .append("mailbox", getMailbox())
            .append("status", getStatus())
            .append("groupLeader", getGroupLeader())
            .append("leaderProfile", getLeaderProfile())
            .append("leaderTel", getLeaderTel())
            .append("leaderEmail", getLeaderEmail())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.coc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 企业会员注册对象 coc_corporate
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public class CocCorporate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业ID */
    private Long cId;

    /** 企业编号 */
    @Excel(name = "企业编号")
    private String cCode;

    /** 名称 */
    @Excel(name = "名称")
    private String cName;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String cUscd;

    /** 类型 */
    @Excel(name = "类型")
    private String cType;

    /** 住所 */
    @Excel(name = "住所")
    private String residence;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String legalReferee;

    /** 注册资本 */
    @Excel(name = "注册资本")
    private String registerCapital;

    /** 成立日期 */
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date foundDate;

    /** 营业期限 */
    @Excel(name = "营业期限")
    private String businessTerm;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String businessScope;

    /** 发证机关 */
    @Excel(name = "发证机关")
    private String issueOffice;

    /** 发证日期 */
    @Excel(name = "发证日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issueDate;

    /** 登记证上传 */
    @Excel(name = "登记证上传")
    private String registration;

    /** 会员级别 */
    @Excel(name = "会员级别")
    private String memberLevel;

    /** 组织简介 */
    @Excel(name = "组织简介")
    private String organProfile;

    /** 经营地址 */
    @Excel(name = "经营地址")
    private String businessAddress;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 组织电话 */
    @Excel(name = "组织电话")
    private String organPhone;

    /** 组织传真 */
    @Excel(name = "组织传真")
    private String organFax;

    /** 组织官网 */
    @Excel(name = "组织官网")
    private String organOfficial;

    /** 组织邮箱 */
    @Excel(name = "组织邮箱")
    private String organEmail;

    /** 入会负责人 */
    @Excel(name = "入会负责人")
    private String joinLeader;

    /** 负责人简介 */
    @Excel(name = "负责人简介")
    private String leaderProfile;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String leaderTel;

    /** 负责人邮箱 */
    @Excel(name = "负责人邮箱")
    private String leaderEmail;

    /** 会员有效期（0是在缴费有效期内 1否在缴费有效期内） */
    @Excel(name = "会员有效期", readConverterExp = "0=是在缴费有效期内,1=否在缴费有效期内")
    private String memberValid;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
    {
        return cId;
    }
    public void setcCode(String cCode) 
    {
        this.cCode = cCode;
    }

    public String getcCode() 
    {
        return cCode;
    }
    public void setcName(String cName) 
    {
        this.cName = cName;
    }

    public String getcName() 
    {
        return cName;
    }
    public void setcUscd(String cUscd) 
    {
        this.cUscd = cUscd;
    }

    public String getcUscd() 
    {
        return cUscd;
    }
    public void setcType(String cType) 
    {
        this.cType = cType;
    }

    public String getcType() 
    {
        return cType;
    }
    public void setResidence(String residence) 
    {
        this.residence = residence;
    }

    public String getResidence() 
    {
        return residence;
    }
    public void setLegalReferee(String legalReferee) 
    {
        this.legalReferee = legalReferee;
    }

    public String getLegalReferee() 
    {
        return legalReferee;
    }
    public void setRegisterCapital(String registerCapital) 
    {
        this.registerCapital = registerCapital;
    }

    public String getRegisterCapital() 
    {
        return registerCapital;
    }
    public void setFoundDate(Date foundDate) 
    {
        this.foundDate = foundDate;
    }

    public Date getFoundDate() 
    {
        return foundDate;
    }
    public void setBusinessTerm(String businessTerm) 
    {
        this.businessTerm = businessTerm;
    }

    public String getBusinessTerm() 
    {
        return businessTerm;
    }
    public void setBusinessScope(String businessScope) 
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope() 
    {
        return businessScope;
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
    public void setRegistration(String registration) 
    {
        this.registration = registration;
    }

    public String getRegistration() 
    {
        return registration;
    }
    public void setMemberLevel(String memberLevel) 
    {
        this.memberLevel = memberLevel;
    }

    public String getMemberLevel() 
    {
        return memberLevel;
    }
    public void setOrganProfile(String organProfile) 
    {
        this.organProfile = organProfile;
    }

    public String getOrganProfile() 
    {
        return organProfile;
    }
    public void setBusinessAddress(String businessAddress) 
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessAddress() 
    {
        return businessAddress;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setOrganPhone(String organPhone) 
    {
        this.organPhone = organPhone;
    }

    public String getOrganPhone() 
    {
        return organPhone;
    }
    public void setOrganFax(String organFax) 
    {
        this.organFax = organFax;
    }

    public String getOrganFax() 
    {
        return organFax;
    }
    public void setOrganOfficial(String organOfficial) 
    {
        this.organOfficial = organOfficial;
    }

    public String getOrganOfficial() 
    {
        return organOfficial;
    }
    public void setOrganEmail(String organEmail) 
    {
        this.organEmail = organEmail;
    }

    public String getOrganEmail() 
    {
        return organEmail;
    }
    public void setJoinLeader(String joinLeader) 
    {
        this.joinLeader = joinLeader;
    }

    public String getJoinLeader() 
    {
        return joinLeader;
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
    public void setMemberValid(String memberValid) 
    {
        this.memberValid = memberValid;
    }

    public String getMemberValid() 
    {
        return memberValid;
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
            .append("cId", getcId())
            .append("cCode", getcCode())
            .append("cName", getcName())
            .append("cUscd", getcUscd())
            .append("cType", getcType())
            .append("residence", getResidence())
            .append("legalReferee", getLegalReferee())
            .append("registerCapital", getRegisterCapital())
            .append("foundDate", getFoundDate())
            .append("businessTerm", getBusinessTerm())
            .append("businessScope", getBusinessScope())
            .append("issueOffice", getIssueOffice())
            .append("issueDate", getIssueDate())
            .append("registration", getRegistration())
            .append("memberLevel", getMemberLevel())
            .append("organProfile", getOrganProfile())
            .append("businessAddress", getBusinessAddress())
            .append("postalCode", getPostalCode())
            .append("organPhone", getOrganPhone())
            .append("organFax", getOrganFax())
            .append("organOfficial", getOrganOfficial())
            .append("organEmail", getOrganEmail())
            .append("joinLeader", getJoinLeader())
            .append("leaderProfile", getLeaderProfile())
            .append("leaderTel", getLeaderTel())
            .append("leaderEmail", getLeaderEmail())
            .append("memberValid", getMemberValid())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

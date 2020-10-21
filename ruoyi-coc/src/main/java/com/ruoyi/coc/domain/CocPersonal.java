package com.ruoyi.coc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 个人会员注册对象 coc_personal
 * 
 * @author ruoyi
 * @date 2020-07-15
 */
public class CocPersonal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 个人ID */
    private Long pId;

    /** 个人编号 */
    @Excel(name = "个人编号")
    private String pCode;

    /** 姓名 */
    @Excel(name = "姓名")
    private String pName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String cardId;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String pSex;

    /** 出生日期 */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 照片上传 */
    @Excel(name = "照片上传")
    private String photo;

    /** 个人介绍 */
    @Excel(name = "个人介绍")
    private String personalProfile;

    /** 社团职务 */
    @Excel(name = "社团职务")
    private String groupPost;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 常驻住址 */
    @Excel(name = "常驻住址")
    private String permanentAddress;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postalCode;

    /** 所在单位 */
    @Excel(name = "所在单位")
    private String placeUnit;

    /** 单位职务 */
    @Excel(name = "单位职务")
    private String unitPosition;

    /** 个人职称 */
    @Excel(name = "个人职称")
    private String personalTitle;

    /** 会员有效期（0是在缴费有效期内 1否在缴费有效期内） */
    @Excel(name = "会员有效期", readConverterExp = "0=是在缴费有效期内,1=否在缴费有效期内")
    private String memberValid;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setpId(Long pId) 
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }
    public void setpCode(String pCode) 
    {
        this.pCode = pCode;
    }

    public String getpCode() 
    {
        return pCode;
    }
    public void setpName(String pName) 
    {
        this.pName = pName;
    }

    public String getpName() 
    {
        return pName;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setpSex(String pSex) 
    {
        this.pSex = pSex;
    }

    public String getpSex() 
    {
        return pSex;
    }
    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setPersonalProfile(String personalProfile) 
    {
        this.personalProfile = personalProfile;
    }

    public String getPersonalProfile() 
    {
        return personalProfile;
    }
    public void setGroupPost(String groupPost) 
    {
        this.groupPost = groupPost;
    }

    public String getGroupPost() 
    {
        return groupPost;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setPermanentAddress(String permanentAddress) 
    {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentAddress() 
    {
        return permanentAddress;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setPlaceUnit(String placeUnit) 
    {
        this.placeUnit = placeUnit;
    }

    public String getPlaceUnit() 
    {
        return placeUnit;
    }
    public void setUnitPosition(String unitPosition) 
    {
        this.unitPosition = unitPosition;
    }

    public String getUnitPosition() 
    {
        return unitPosition;
    }
    public void setPersonalTitle(String personalTitle) 
    {
        this.personalTitle = personalTitle;
    }

    public String getPersonalTitle() 
    {
        return personalTitle;
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
            .append("pId", getpId())
            .append("pCode", getpCode())
            .append("pName", getpName())
            .append("cardId", getCardId())
            .append("pSex", getpSex())
            .append("birthDate", getBirthDate())
            .append("photo", getPhoto())
            .append("personalProfile", getPersonalProfile())
            .append("groupPost", getGroupPost())
            .append("nativePlace", getNativePlace())
            .append("permanentAddress", getPermanentAddress())
            .append("postalCode", getPostalCode())
            .append("placeUnit", getPlaceUnit())
            .append("unitPosition", getUnitPosition())
            .append("personalTitle", getPersonalTitle())
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

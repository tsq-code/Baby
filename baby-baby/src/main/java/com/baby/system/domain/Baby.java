package com.baby.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.baby.common.annotation.Excel;
import com.baby.common.core.domain.BaseEntity;

/**
 * 信息录入对象 baby
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public class Baby extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birth;

    /** 出生地 */
    @Excel(name = "出生地")
    private String address;

    /** 出生孕周 */
    @Excel(name = "出生孕周")
    private String weekNum;

    /** 健康状况 */
    @Excel(name = "健康状况")
    private String status;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    /** 体长 */
    @Excel(name = "体长")
    private String height;

    /** 母亲姓名 */
    @Excel(name = "母亲姓名")
    private String nameMother;

    /** 年龄 */
    @Excel(name = "年龄")
    private String ageMother;

    /** 国籍 */
    @Excel(name = "国籍")
    private String countryMother;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idMother;

    /** 父亲姓名 */
    @Excel(name = "父亲姓名")
    private String nameFather;

    /** 年龄 */
    @Excel(name = "年龄")
    private String ageFather;

    /** 国籍 */
    @Excel(name = "国籍")
    private String countryFather;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idFather;

    /** 出生地点分类 */
    @Excel(name = "出生地点分类")
    private String location;

    /** 接生人员 */
    @Excel(name = "接生人员")
    private String doctor;

    /** 接生机构名称 */
    @Excel(name = "接生机构名称")
    private String hospital;

    /** 签发时间 */
    @Excel(name = "签发时间")
    private String today;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirth(String birth) 
    {
        this.birth = birth;
    }

    public String getBirth() 
    {
        return birth;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setWeekNum(String weekNum) 
    {
        this.weekNum = weekNum;
    }

    public String getWeekNum() 
    {
        return weekNum;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }
    public void setHeight(String height) 
    {
        this.height = height;
    }

    public String getHeight() 
    {
        return height;
    }
    public void setNameMother(String nameMother) 
    {
        this.nameMother = nameMother;
    }

    public String getNameMother() 
    {
        return nameMother;
    }
    public void setAgeMother(String ageMother) 
    {
        this.ageMother = ageMother;
    }

    public String getAgeMother() 
    {
        return ageMother;
    }
    public void setCountryMother(String countryMother) 
    {
        this.countryMother = countryMother;
    }

    public String getCountryMother() 
    {
        return countryMother;
    }
    public void setIdMother(String idMother) 
    {
        this.idMother = idMother;
    }

    public String getIdMother() 
    {
        return idMother;
    }
    public void setNameFather(String nameFather) 
    {
        this.nameFather = nameFather;
    }

    public String getNameFather() 
    {
        return nameFather;
    }
    public void setAgeFather(String ageFather) 
    {
        this.ageFather = ageFather;
    }

    public String getAgeFather() 
    {
        return ageFather;
    }
    public void setCountryFather(String countryFather) 
    {
        this.countryFather = countryFather;
    }

    public String getCountryFather() 
    {
        return countryFather;
    }
    public void setIdFather(String idFather) 
    {
        this.idFather = idFather;
    }

    public String getIdFather() 
    {
        return idFather;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setDoctor(String doctor) 
    {
        this.doctor = doctor;
    }

    public String getDoctor() 
    {
        return doctor;
    }
    public void setHospital(String hospital) 
    {
        this.hospital = hospital;
    }

    public String getHospital() 
    {
        return hospital;
    }
    public void setToday(String today) 
    {
        this.today = today;
    }

    public String getToday() 
    {
        return today;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("birth", getBirth())
            .append("address", getAddress())
            .append("weekNum", getWeekNum())
            .append("status", getStatus())
            .append("weight", getWeight())
            .append("height", getHeight())
            .append("nameMother", getNameMother())
            .append("ageMother", getAgeMother())
            .append("countryMother", getCountryMother())
            .append("idMother", getIdMother())
            .append("nameFather", getNameFather())
            .append("ageFather", getAgeFather())
            .append("countryFather", getCountryFather())
            .append("idFather", getIdFather())
            .append("location", getLocation())
            .append("doctor", getDoctor())
            .append("hospital", getHospital())
            .append("today", getToday())
            .toString();
    }
}

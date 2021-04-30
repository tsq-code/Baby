package com.baby.system.mapper;

import java.util.List;
import com.baby.system.domain.Baby;

/**
 * 信息录入Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public interface BabyMapper 
{
    /**
     * 查询信息录入
     * 
     * @param id 信息录入ID
     * @return 信息录入
     */
    public Baby selectBabyById(Integer id);

    /**
     * 查询信息录入列表
     * 
     * @param baby 信息录入
     * @return 信息录入集合
     */
    public List<Baby> selectBabyList(Baby baby);

    /**
     * 新增信息录入
     * 
     * @param baby 信息录入
     * @return 结果
     */
    public int insertBaby(Baby baby);

    /**
     * 修改信息录入
     * 
     * @param baby 信息录入
     * @return 结果
     */
    public int updateBaby(Baby baby);

    /**
     * 删除信息录入
     * 
     * @param id 信息录入ID
     * @return 结果
     */
    public int deleteBabyById(Integer id);

    /**
     * 批量删除信息录入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBabyByIds(Integer[] ids);
}

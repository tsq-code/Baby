package com.baby.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baby.system.mapper.BabyMapper;
import com.baby.system.domain.Baby;
import com.baby.system.service.IBabyService;

/**
 * 信息录入Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@Service
public class BabyServiceImpl implements IBabyService 
{
    @Autowired
    private BabyMapper babyMapper;

    /**
     * 查询信息录入
     * 
     * @param id 信息录入ID
     * @return 信息录入
     */
    @Override
    public Baby selectBabyById(Integer id)
    {
        return babyMapper.selectBabyById(id);
    }

    /**
     * 查询信息录入列表
     * 
     * @param baby 信息录入
     * @return 信息录入
     */
    @Override
    public List<Baby> selectBabyList(Baby baby)
    {
        return babyMapper.selectBabyList(baby);
    }

    /**
     * 新增信息录入
     * 
     * @param baby 信息录入
     * @return 结果
     */
    @Override
    public int insertBaby(Baby baby)
    {
        return babyMapper.insertBaby(baby);
    }

    /**
     * 修改信息录入
     * 
     * @param baby 信息录入
     * @return 结果
     */
    @Override
    public int updateBaby(Baby baby)
    {
        return babyMapper.updateBaby(baby);
    }

    /**
     * 批量删除信息录入
     * 
     * @param ids 需要删除的信息录入ID
     * @return 结果
     */
    @Override
    public int deleteBabyByIds(Integer[] ids)
    {
        return babyMapper.deleteBabyByIds(ids);
    }

    /**
     * 删除信息录入信息
     * 
     * @param id 信息录入ID
     * @return 结果
     */
    @Override
    public int deleteBabyById(Integer id)
    {
        return babyMapper.deleteBabyById(id);
    }
}

package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 20:55
 */
public interface AdPlanDao {

    /**
     * 查询单条记录
     * @param id 计划id
     * @param userId 用户id
     * @return
     */
    AdPlan findByIdAndUserId(Long id, Long userId);

    /**
     * 查询多条记录
     * @param ids 计划ids
     * @param userId 用户id
     * @return
     */
    List<AdPlan> findAllByIdInAndUserId(List<Long> ids, Long userId);

    /**
     * 查询单条记录
     * @param userId 用户id
     * @param planName 计划名称
     * @return
     */
    AdPlan findByIdAndPlanName(Long userId, String planName);

    /**
     * 查询多条记录
     * @param status 状态
     * @return
     */
    List<AdPlan> findAllByPlanStatus(Integer status);
}

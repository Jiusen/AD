package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:04
 */
public interface AdUnitDao {

    /**
     * 得到单条记录
     * @param planId    计划id
     * @param unitName  单元名字
     * @return
     */
    AdUnit findByPlanIdAndUnitName(Long planId, String unitName);

    /**
     * 多条记录
     * @param unitStatus    单元状态
     * @return
     */
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}

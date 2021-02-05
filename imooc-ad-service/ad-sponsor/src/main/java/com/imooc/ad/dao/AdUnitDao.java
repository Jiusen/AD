package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:04
 */
@Repository
public interface AdUnitDao {

    /**
     * 得到单条记录
     * @param id    推广单元id
     * @return
     */
    AdUnit findById(Long id);

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

    /**
     * 添加推广单元
     * @param adUnit
     * @return
     */
    Long save(AdUnit adUnit);
}

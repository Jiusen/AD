package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.AdUnitIt;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:11
 */
@Repository
public interface AdUnitItDao {
    /**
     * 批量插入数据
     * @param unitIts
     * @return
     */
    List<Long> saveAll(List<AdUnitIt> unitIts);

    /**
     * 得到所有记录
     * @return
     */
    List<AdUnitIt> findAll();
}

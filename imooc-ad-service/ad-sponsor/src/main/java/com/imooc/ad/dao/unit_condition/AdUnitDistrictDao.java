package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.AdUnitDistrict;
import com.imooc.ad.entity.unit_condition.AdUnitIt;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:12
 */
@Repository
public interface AdUnitDistrictDao {
    /**
     * 批量插入数据
     * @param unitIts
     * @return
     */
    List<Long> saveAll(List<AdUnitDistrict> unitIts);

    /**
     * 得到所有记录
     * @return
     */
    List<AdUnitDistrict> findAll();
}

package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.CreativeUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:12
 */
@Repository
public interface CreativeUnitDao {

    /**
     * 批量保存
     * @param creativeUnits
     * @return
     */
    List<Long> saveAll(List<CreativeUnit> creativeUnits);

    /**
     * 得到所有数据记录
     * @return
     */
    List<CreativeUnit> findAll();
}

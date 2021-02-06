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

    List<Long> saveAll(List<CreativeUnit> creativeUnits);
}

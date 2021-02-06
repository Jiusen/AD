package com.imooc.ad.dao.unit_condition;

import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:10
 */
@Repository
public interface AdUnitKeywordDao {

    /**
     * 批量插入数据
     * @param unitKeywords
     * @return
     */
    List<Long> saveAll(List<AdUnitKeyword> unitKeywords);
}

package com.imooc.ad.index.keyword;

import com.imooc.ad.index.IndexAware;
import com.imooc.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 20:49
 * 这个使用倒排索引
 */
@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {

    private static Map<String, Set<Long>> keywordUnitMap;  //关键词到推广单元的索引
    private static Map<Long, Set<String>> unitKeywordMap;  //推广单元到关键词的索引

    static {
        keywordUnitMap = new ConcurrentHashMap<>();
        unitKeywordMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }
        Set<Long> result = keywordUnitMap.get(key);
        if (result == null) {
            return Collections.emptySet();
        }
        return result;
    }

    @Override
    public void add(String key, Set<Long> value) {
        log.info("UnitKeywowrdIndex, before add: {}", unitKeywordMap);

        /**
         * 尝试从 keywordUnitMap 中获取 key（即 Map.get(key)），得到一个 ConcurrentSkipListSet。
         * 如果获取不到，则通过 ConcurrentSkipListSet::new 工厂创建一个 ConcurrentSkipListSet 对象。
         * 且此时，这个 key 对应的值 已经 put 到 ConcurrentSkipListSet 中了。
         */
        Set<Long> unitIdSet = CommonUtils.getorCreate(key, keywordUnitMap, ConcurrentSkipListSet::new);
        /**
         *  由于获取到的 unitIdSet 是 keywordUnitMap 中的 key 对应到的 value。
         *  所以，unitIdSet 的修改可以简单的认为是：keywordUnitMap.put(key, unitIdSet)。
         */
        unitIdSet.addAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getorCreate(unitId, unitKeywordMap, ConcurrentSkipListSet::new);
            keywordSet.add(key);
        }

        log.info("UnitKeywordIndex, after add: {}", unitKeywordMap);
    }

    @Override
    public void update(String key, Set<Long> value) {

        log.error("keyword index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before delete: {}", unitKeywordMap);

        Set<Long> unitIds = CommonUtils.getorCreate(key, keywordUnitMap, ConcurrentSkipListSet::new);
        unitIds.removeAll(value);

        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtils.getorCreate(unitId, unitKeywordMap, ConcurrentSkipListSet::new);
            keywordSet.remove(key);
        }

        log.info("UnitKeywordIndex, after delete: {}", unitKeywordMap);
    }

    //匹配
    public boolean match(Long unitId, List<String> keywords) {

        /**
         * unitKeywordMap索引里面包含了给定的unitId
         */
        if (unitKeywordMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))) {

            Set<String> unitKeywords = unitKeywordMap.get(unitId);

            //当keywords 是 unitKeywords 的子集的时候才返回true
            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }

        return false;
    }
}

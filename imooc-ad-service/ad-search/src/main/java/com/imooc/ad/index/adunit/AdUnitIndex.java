package com.imooc.ad.index.adunit;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 20:34
 * 这里使用正向索引
 */
@Slf4j
@Component
public class AdUnitIndex implements IndexAware<Long, AdUnitObject> {

    //存储数据表中所有的记录
    private static Map<Long, AdUnitObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>(); //支持并发
    }

    /**
     * 匹配
     * @param positionType  位置类型
     * @return
     */
    public Set<Long> match(Integer positionType) {

        Set<Long> adUnitIds = new HashSet<>();

        objectMap.forEach((k, v) -> {
            if (AdUnitObject.isAdSlotTypeOK(positionType,
                    v.getPositionType())) {
                adUnitIds.add(k);
            }
        });

        return adUnitIds;
    }

    /**
     * 得到对应的存储数据
     * @param adUnitIds
     * @return
     */
    public List<AdUnitObject> fetch(Collection<Long> adUnitIds) {

        if (CollectionUtils.isEmpty(adUnitIds)) {
            return Collections.emptyList();
        }

        List<AdUnitObject> result = new ArrayList<>();

        adUnitIds.forEach(u -> {
            AdUnitObject object = get(u);
            if (object == null) {
                log.error("AdUnitObject not found: {}", u);
                return;
            }
            result.add(object);
        });

        return result;
    }
    @Override
    public AdUnitObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdUnitObject value) {

        log.info("before add: {}", objectMap);
        objectMap.put(key, value);
        log.info("after add: {}", objectMap);
    }

    @Override
    public void update(Long key, AdUnitObject value) {

        log.info("before update: {}", objectMap);

        //null直接插入 or 更新（自定义查看）
        AdUnitObject oldObject = objectMap.get(key);
        if (null == oldObject) {
            objectMap.put(key, value);
        } else {
            oldObject.update(value);
        }

        log.info("after update: {}", objectMap);
    }

    @Override
    public void delete(Long key, AdUnitObject value) {

        log.info("before delete: {}", objectMap);
        objectMap.remove(key);
        log.info("after delete: {}", objectMap);
    }
}

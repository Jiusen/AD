package com.imooc.ad.utils;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 21:00
 */
public class CommonUtils {

    /**
     *
     * @param key
     * @param map
     * @param factory
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> V getorCreate(K key, Map<K, V> map, Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }
}

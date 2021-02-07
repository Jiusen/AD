package com.imooc.ad.index;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 19:50
 * 索引相关
 */
public interface IndexAware<K, V> {

    /**
     * 获得对应的记录
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 添加记录
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 更新记录
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     * 删除记录
     * @param key
     * @param value
     */
    void delete(K key, V value);
}

package com.imooc.ad.handler;

import com.imooc.ad.dump.table.AdCreativeTable;
import com.imooc.ad.dump.table.AdPlanTable;
import com.imooc.ad.index.DataTable;
import com.imooc.ad.index.IndexAware;
import com.imooc.ad.index.adplan.AdPlanIndex;
import com.imooc.ad.index.adplan.AdPlanObject;
import com.imooc.ad.index.creative.CreativeIndex;
import com.imooc.ad.index.creative.CreativeObject;
import com.imooc.ad.mysql.constant.OpType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiusen Guo
 * @date 2021/2/8 19:28
 * 1. 索引之间存在着层级的划分，也就是依赖关系的划分
 * 2. 加载全量索引其实就是增量索引 “添加” 的一种特殊实现
 */
@Slf4j
public class AdLevelDataHandler {

    /**
     * 从文件中得到 推广计划 ，进行特定的操作（增删改查）
     * @param planTable 推广计划
     * @param type  操作
     */
    public static void handleLevel2(AdPlanTable planTable, OpType type) {

        //得到 inedx-object 的 object
        AdPlanObject planObject = new AdPlanObject(
                planTable.getId(),
                planTable.getUserId(),
                planTable.getPlanStatus(),
                planTable.getStartDate(),
                planTable.getEndDate()
        );
        //处理
        handleBinlogEvent(DataTable.of(AdPlanIndex.class), planObject.getPlanId(), planObject, type);
    }

    /**
     * 从文件中得到 创意表 ，进行特定的操作（增删改查）
     * @param creativeTable 文件中创意表的数据
     * @param type
     */
    public static void handleLevel2(AdCreativeTable creativeTable, OpType type) {

        CreativeObject creativeObject = new CreativeObject(
                creativeTable.getAdId(),
                creativeTable.getName(),
                creativeTable.getType(),
                creativeTable.getMaterialType(),
                creativeTable.getHeight(),
                creativeTable.getWidth(),
                creativeTable.getAuditStatus(),
                creativeTable.getAdUrl()
        );
        handleBinlogEvent(DataTable.of(CreativeIndex.class), creativeObject.getAdId(), creativeObject, type);
    }

    //实现索引的 crud
    private static <K, V> void handleBinlogEvent(IndexAware<K, V> index, K key, V value, OpType type) {
        switch (type) {
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }
    }
}

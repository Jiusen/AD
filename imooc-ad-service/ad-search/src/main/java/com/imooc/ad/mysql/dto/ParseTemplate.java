package com.imooc.ad.mysql.dto;

import com.imooc.ad.mysql.constant.OpType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 19:45
 */
@Data
public class ParseTemplate {

    /**
     * 模板中的数据库
     */
    private String database;

    /**
     * 各个表对应的操作
     */
    private Map<String, TableTemplate> tableTemplateMap = new HashMap<>();

    /**
     * 模板数据解析，
     * @param _template
     * @return
     */
    public static ParseTemplate parse(Template _template) {

        ParseTemplate template = new ParseTemplate();

        //解析出数据库名
        template.setDatabase(_template.getDatabase());

        //解析对应的表
        for (JsonTable table : _template.getTableList()) {
            String name = table.getTableName();   //表名
            Integer level = table.getLevel();    //表的操作类型

            TableTemplate tableTemplate = new TableTemplate();
            tableTemplate.setTableName(name);
            tableTemplate.setLevel(level.toString());
            template.tableTemplateMap.put(name, tableTemplate);

            //遍历操作类型对应的列
            Map<OpType, List<String>> opTypeFieldSetMap = tableTemplate.getOpTypeFieldSetMap();

            for (JsonTable.Column column : table.getInsert()) {
                getAndCreateIfNeed(
                        OpType.ADD,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
            for (JsonTable.Column column : table.getUpdate()) {
                getAndCreateIfNeed(
                        OpType.UPDATE,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
            for (JsonTable.Column column : table.getDelete()) {
                getAndCreateIfNeed(
                        OpType.DELETE,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
        }
        return template;
    }

    private static <T, R> R getAndCreateIfNeed(T key, Map<T, R> map, Supplier<R> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }
}

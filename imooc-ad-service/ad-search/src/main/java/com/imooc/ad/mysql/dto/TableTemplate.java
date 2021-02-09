package com.imooc.ad.mysql.dto;

import com.imooc.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 19:17
 * 记录表 字段的操作类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTemplate {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 操作层级
     */
    private String level;

    /**
     * 操作类型 对应的列
     */
    private Map<OpType, List<String>> opTypeFieldSetMap = new HashMap<>();

    /**
     * 字段索引 -> 字段名
     */
    private Map<Integer, String> posMap = new HashMap<>();
}

package com.imooc.ad.mysql.dto;

import com.imooc.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySqlRowData {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 层级
     */
    private String level;

    /**
     * 操作类型
     */
    private OpType opType;

    /**
     * 每一条记录的值
     */
    private List<Map<String, String>> fieldValueMap = new ArrayList<>();
}

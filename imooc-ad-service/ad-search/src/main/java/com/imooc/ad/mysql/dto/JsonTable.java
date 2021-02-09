package com.imooc.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 19:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonTable {

    private String tableName;
    private Integer level;

    private List<Column> insert;
    private List<Column> update;
    private List<Column> delete;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Column {
        private String column;
    }
}

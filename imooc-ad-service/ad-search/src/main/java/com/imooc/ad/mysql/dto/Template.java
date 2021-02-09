package com.imooc.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 19:15
 * 模板 json 数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    /**
     * 数据库
     */
    private String database;

    /**
     * 所有表
     */
    private List<JsonTable> tableList;
}

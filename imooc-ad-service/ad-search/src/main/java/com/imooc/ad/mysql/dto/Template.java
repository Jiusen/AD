package com.imooc.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 19:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    private String databases;
    private List<JsonTable> tableList;
}

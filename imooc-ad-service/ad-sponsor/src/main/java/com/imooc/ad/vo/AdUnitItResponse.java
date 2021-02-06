package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/5 22:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItResponse {

    //返回插入后的id
    private List<Long> ids;
}

package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/5 22:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitDistrictResponse {

    //返回导入后的id
    private List<Long> ids;
}

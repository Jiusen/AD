package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/5 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItRequest {

    //允许批量导入 -兴趣
    private List<UnitIt> unitIts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitIt {
        private Long unitId;
        private String itTag;
    }
}

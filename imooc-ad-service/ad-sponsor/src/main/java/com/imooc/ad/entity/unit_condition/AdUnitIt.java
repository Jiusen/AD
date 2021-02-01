package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 18:48
 * 推广单元-兴趣
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitIt {
    /**
     * 推广单元兴趣唯一 id
     */
    private Long id;
    /**
     * 推广单元 id
     */
    private Long unitId;
    /**
     * 兴趣标签
     */
    private String itTag;

    public AdUnitIt(Long unitId, String itTag) {
        this.unitId = unitId;
        this.itTag = itTag;
    }
}

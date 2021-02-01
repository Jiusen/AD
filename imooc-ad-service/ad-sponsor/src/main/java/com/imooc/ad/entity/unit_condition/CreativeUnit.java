package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 19:23
 * 创意与推广单元的关联表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnit {
    private Long id;
    /**
     * 创意 id
     */
    private Long creativeId;
    /**
     * 推广单元 id
     */
    private Long unitId;

    public CreativeUnit(Long creativeId, Long unitId) {
        this.creativeId = creativeId;
        this.unitId = unitId;
    }
}

package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 18:43
 * 推广单元-关键词
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeyword {
    /**
     * 推广单元关键词 唯一id
     */
    private Long id;
    /**
     * 推广单元 id
     */
    private Long unitId;
    /**
     * 关键词
     */
    private String keyword;

    public AdUnitKeyword(Long unitId, String keyword) {
        this.unitId = unitId;
        this.keyword = keyword;
    }
}

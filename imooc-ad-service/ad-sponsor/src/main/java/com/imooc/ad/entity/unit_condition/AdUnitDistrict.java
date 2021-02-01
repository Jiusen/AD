package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 18:52
 * 推广单元-地域
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrict {
    /**
     * 推广单元地域唯一 id
     */
    private Long id;
    /**
     * 推广单元 id
     */
    private Long unitId;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;

    public AdUnitDistrict(Long unitId, String province, String city) {
        this.unitId = unitId;
        this.province = province;
        this.city = city;
    }
}

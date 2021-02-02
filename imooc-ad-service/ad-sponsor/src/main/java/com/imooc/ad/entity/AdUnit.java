package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 18:27
 * 推广单元
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnit {
    /**
     * 推广单元唯一id
     */
    private Long id;
    /**
     * 推广单元绑定的推广计划id
     */
    private Long planId;
    /**
     * 推广单元名称
     */
    private String unitName;
    /**
     * 推广单元状态
     */
    private Integer unitStatus;
    /**
     * 广告位类型（开屏、贴片、中贴、暂停贴，后贴...）
     */
    private Integer positionType;
    /**
     * 预算
     */
    private Long budget;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 更新日期
     */
    private Date updateTime;

    public AdUnit(Long planId, String unitName, Integer positionType, Long budget) {
        this.planId = planId;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.positionType = positionType;
        this.budget = budget;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}

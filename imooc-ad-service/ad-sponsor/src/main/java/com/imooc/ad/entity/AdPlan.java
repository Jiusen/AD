package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 18:16
 * 推广计划
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlan {

    /**
     * 计划唯一id
     */
    private Long id;
    /**
     * 绑定的用户id
     */
    private Long userId;
    /**
     * 计划标题
     */
    private String planName;
    /**
     * 计划状态 开/关
     */
    private Integer planStatus;
    /**
     * 计划起始日期
     */
    private Date startDate;
    /**
     * 计划终止日期
     */
    private Date endDate;
    /**
     * 计划创建时间
     */
    private Date createTime;
    /**
     * 计划更新时间
     */
    private Date updateTime;

    public AdPlan(Long userId, String planName, Date startDate, Date endDate) {
        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}

package com.imooc.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 19:00
 * 创意表（提供给用户看的）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Creative {
    /**
     * 创意表唯一id
     */
    private Long id;
    /**
     * 创意名称
     */
    private String name;
    /**
     * 物料类型(图片, 视频)
     */
    private Integer type;
    /**
     * 物料子类型(图片: bmp, jpg 等等)
     */
    private Integer materialType;
    /**
     * 高度
     */
    private Integer height;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * 物料大小, 单位是 KB
     */
    private Long size;
    /**
     * 持续时长, 只有视频才不为 0
     */
    private Integer duration;
    /**
     * 审核状态
     */
    private Integer auditStatus;
    /**
     * 标记当前记录所属用户
     */
    private Long userId;
    /**
     * 物料地址
     */
    private String url;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}

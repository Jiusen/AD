package com.imooc.ad.enums;

import lombok.Getter;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 16:56
 */
@Getter
public enum  CommonStatus {

    VALID(1, "有效状态"), INVALID(2, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}

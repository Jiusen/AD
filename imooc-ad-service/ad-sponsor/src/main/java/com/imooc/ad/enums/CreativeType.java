package com.imooc.ad.enums;

import lombok.Getter;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 19:25
 */
@Getter
public enum CreativeType {

    IMAGE(1, "图片"), VIDEO(2, "视频"), TEXT(3, "文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}

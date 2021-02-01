package com.imooc.ad.enums;

import lombok.Getter;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 19:27
 */
@Getter
public enum CreativeMetrialType {

    JPG(1, "jpg"), BMP(2, "bmp"),
    Mp4(3, "mp4"), AVI(4, "avi"),
    TXT(6, "txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}

package com.imooc.ad.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Jiusen Guo
 * @date 2021/2/2 20:39
 */
public class CommonUtils {

    /**
     * 获取字符串MD5加密后的字符串
     * @param value
     * @return
     */
    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }
}

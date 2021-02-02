package com.imooc.ad.util;

import com.imooc.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/2 20:39
 */
public class CommonUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-/MM/dd", "yyyy.MM.dd"};

    /**
     * 获取字符串MD5加密后的字符串
     * @param value
     * @return
     */
    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    /**
     * 字符串->日期的转换
     * @param dateString
     * @return
     * @throws AdException
     */
    public static Date parseStringDate(String dateString) throws AdException {
        try {
            return DateUtils.parseDate(dateString, parsePatterns);
        } catch (ParseException e) {
            throw new AdException(e.getMessage());
        }
    }
}

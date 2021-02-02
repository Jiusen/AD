package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 16:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUser {

    /**
     * 用户唯一id
     */
    private Long id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户标识
     */
    private String token;

    /**
     * 用户状态，可用/不可用
     */
    private Integer userStatus;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 更新日期
     */
    private Date updateTime;

    public AdUser(String username, String token) {
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}

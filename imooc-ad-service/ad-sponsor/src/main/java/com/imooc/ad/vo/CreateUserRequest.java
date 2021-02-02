package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author Jiusen Guo
 * @date 2021/2/2 19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;

    public boolean validate() {
        return !StringUtils.isEmpty(username);
    }
}

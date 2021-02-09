package com.imooc.ad.sender;

import com.imooc.ad.mysql.dto.MySqlRowData;

/**
 * @author Jiusen Guo
 * @date 2021/2/9 21:17
 */
public interface ISender {
    void sender(MySqlRowData rowData);
}

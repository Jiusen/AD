package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiusen Guo
 * @date 2021/2/8 17:18
 * 推广单元-兴趣
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItTable {

    private Long unitId;
    private String itTag;
}

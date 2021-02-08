package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jiusen Guo
 * @date 2021/2/8 17:17
 * 推广单元-计划
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanTable {

    private Long id;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
}

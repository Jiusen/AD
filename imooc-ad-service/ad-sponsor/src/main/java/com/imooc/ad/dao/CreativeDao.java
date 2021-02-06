package com.imooc.ad.dao;

import com.imooc.ad.entity.Creative;
import org.springframework.stereotype.Repository;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:07
 */
@Repository
public interface CreativeDao {

    Long save(Creative creative);
}

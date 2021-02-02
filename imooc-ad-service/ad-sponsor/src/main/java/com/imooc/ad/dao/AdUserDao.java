package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 20:49
 */
@Repository
public interface AdUserDao {

    /**
     * 通过用户名字得到用户记录
     * @param username
     * @return
     */
    AdUser findByUserName(String username);
    AdUser findByIde(Long id);

    Long save(AdUser adUser);
}

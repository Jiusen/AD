package com.imooc.ad.dao;

import com.imooc.ad.entity.Creative;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:07
 */
@Repository
public interface CreativeDao {

    /**
     * 多条添加 -创意单元
     * @param creative
     * @return
     */
    Long save(Creative creative);

    /**
     * 得到所有记录
     * @param creativeIds 创意 ids
     * @return
     */
    List<Creative> findAllById(List<Long> creativeIds);
}

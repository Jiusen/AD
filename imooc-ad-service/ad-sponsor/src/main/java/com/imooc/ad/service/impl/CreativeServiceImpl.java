package com.imooc.ad.service.impl;

import com.imooc.ad.dao.CreativeDao;
import com.imooc.ad.entity.Creative;
import com.imooc.ad.service.ICreativeService;
import com.imooc.ad.vo.CreativeRequest;
import com.imooc.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 0:55
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeDao creativeDao;

    @Autowired
    public CreativeServiceImpl(CreativeDao creativeDao) {
        this.creativeDao = creativeDao;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Long id = creativeDao.save(request.convertToEntity());
        return new CreativeResponse(id, request.getName());
    }
}

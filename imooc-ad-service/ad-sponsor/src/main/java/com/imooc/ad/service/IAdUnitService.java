package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdUnitRequest;
import com.imooc.ad.vo.AdUnitResponse;

/**
 * @author Jiusen Guo
 * @date 2021/2/3 1:18
 */
public interface IAdUnitService {

    /**
     * 添加推广单元
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

}

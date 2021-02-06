package com.imooc.ad.service;

import com.imooc.ad.vo.CreativeRequest;
import com.imooc.ad.vo.CreativeResponse;

/**
 * @author Jiusen Guo
 * @date 2021/2/7 0:54
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}

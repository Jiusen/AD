package com.imooc.ad.search;


import com.imooc.ad.search.vo.SearchRequest;
import com.imooc.ad.search.vo.SearchResponse;

/**
 * 搜索服务接口
 */
public interface ISearch {

    /**
     * 搜索服务
     * @param request 请求数据
     * @return  返回应答
     */
    SearchResponse fetchAds(SearchRequest request);
}

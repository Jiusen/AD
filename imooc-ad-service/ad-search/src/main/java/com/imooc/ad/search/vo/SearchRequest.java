package com.imooc.ad.search.vo;

import com.imooc.ad.search.vo.feature.DistrictFeature;
import com.imooc.ad.search.vo.feature.FeatureRelation;
import com.imooc.ad.search.vo.feature.ItFeature;
import com.imooc.ad.search.vo.feature.KeywordFeature;
import com.imooc.ad.search.vo.media.AdSlot;
import com.imooc.ad.search.vo.media.App;
import com.imooc.ad.search.vo.media.Device;
import com.imooc.ad.search.vo.media.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jiusen Guo
 * @date 2021/2/14 2:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    //媒体方的请求表示
    private String mediaId;

    //请求基本信息
    private RequestInfo requestInfo;

    //匹配信息
    private FeatureInfo featureInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private ItFeature itFeature;
        private DistrictFeature districtFeature;

        private FeatureRelation relation = FeatureRelation.AND;
    }
}

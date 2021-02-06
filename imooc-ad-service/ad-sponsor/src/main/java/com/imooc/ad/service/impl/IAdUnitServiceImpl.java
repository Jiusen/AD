package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdPlanDao;
import com.imooc.ad.dao.AdUnitDao;
import com.imooc.ad.dao.unit_condition.AdUnitDistrictDao;
import com.imooc.ad.dao.unit_condition.AdUnitItDao;
import com.imooc.ad.dao.unit_condition.AdUnitKeywordDao;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.unit_condition.AdUnitDistrict;
import com.imooc.ad.entity.unit_condition.AdUnitIt;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdUnitService;
import com.imooc.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiusen Guo
 * @date 2021/2/3 1:19
 */
@Service
public class IAdUnitServiceImpl implements IAdUnitService {

    @Autowired
    private AdPlanDao adPlanDao;

    @Autowired
    private AdUnitDao adUnitDao;

    @Autowired
    private AdUnitKeywordDao adUnitKeywordDao;

    @Autowired
    private AdUnitItDao adUnitItDao;

    @Autowired
    private AdUnitDistrictDao adUnitDistrictDao;

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdPlan adPlan = adPlanDao.findById(request.getPlanId());
        if (adPlan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdUnit oldAdUnit = adUnitDao.findByPlanIdAndUnitName(
                request.getPlanId(), request.getUnitName()
        );
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        Long newAdUnitId = adUnitDao.save(
                new AdUnit(request.getPlanId(), request.getUnitName(),
                        request.getPositionType(), request.getBudget())
        );

        AdUnit newAdUnit = adUnitDao.findById(newAdUnitId);

        return new AdUnitResponse(newAdUnit.getId(),
                newAdUnit.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        List<Long> unitIds = request.getUnitKeywords().stream()   //双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)  //Object::function 代表这个对象的方法
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<Long> ids = Collections.emptyList();

        List<AdUnitKeyword> unitKeywords = new ArrayList<>();

        //遍历添加（单元id、关键词）
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(i -> unitKeywords.add(
                    new AdUnitKeyword(i.getUnitId(), i.getKeyword())
            ));

            //批量插入
            adUnitKeywordDao.saveAll(unitKeywords);

            //得到批量插入后数据的 ids
            ids = unitKeywords.stream()
                    .map(AdUnitKeyword::getId)
                    .collect(Collectors.toList());
        }
        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getUnitIts().stream()   //双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .map(AdUnitItRequest.UnitIt::getUnitId)  //Object::function 代表这个对象的方法
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();

        List<AdUnitIt> unitIts = new ArrayList<>();

        //遍历添加（单元id、关键词）
        if (!CollectionUtils.isEmpty(request.getUnitIts())) {
            request.getUnitIts().forEach(i -> unitIts.add(
                    new AdUnitIt(i.getUnitId(), i.getItTag())
            ));

            //批量插入
            adUnitItDao.saveAll(unitIts);

            //得到批量插入后数据的 ids
            ids = unitIts.stream()
                    .map(AdUnitIt::getId)
                    .collect(Collectors.toList());
        }
        return new AdUnitItResponse(ids);
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream()   //双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .map(AdUnitDistrictRequest.UnitDistrict::getUnitId)  //Object::function 代表这个对象的方法
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();

        List<AdUnitDistrict> unitDistricts = new ArrayList<>();

        //遍历添加（单元id、关键词）
        if (!CollectionUtils.isEmpty(request.getUnitDistricts())) {
            request.getUnitDistricts().forEach(i -> unitDistricts.add(
                    new AdUnitDistrict(i.getUnitId(), i.getProvince(), i.getCity())
            ));

            //批量插入
            adUnitDistrictDao.saveAll(unitDistricts);

            //得到批量插入后数据的 ids
            ids = unitDistricts.stream()
                    .map(AdUnitDistrict::getId)
                    .collect(Collectors.toList());
        }
        return new AdUnitDistrictResponse(ids);
    }

    private boolean isRelatedUnitExist(List<Long> unitIds) {
        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }
        return adUnitDao.findAllById(unitIds).size() == new HashSet<>(unitIds).size();
    }
}

package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdUserDao;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserService;
import com.imooc.ad.util.CommonUtils;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jiusen Guo
 * @date 2021/2/2 20:17
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {


    private final AdUserDao adUserDao;

    @Autowired
    public UserServiceImpl(AdUserDao adUserDao) {
        this.adUserDao = adUserDao;
    }


    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        /**
         * 请求的用户名为空
         */
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        /**
         * 已存在同名用户
         */
        AdUser oldUser = adUserDao.findByUserName(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        /**
         * 插入记录
         */
        Long id = adUserDao.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())));

        /**
         * 得到刚才插入的记录
         */
        AdUser newUser = adUserDao.findByUserName(request.getUsername());

        /**
         * 返回数据
         */
        return new CreateUserResponse(newUser.getId(), newUser.getUsername(), newUser.getToken(), newUser.getCreateTime(), newUser.getUpdateTime());

    }
}

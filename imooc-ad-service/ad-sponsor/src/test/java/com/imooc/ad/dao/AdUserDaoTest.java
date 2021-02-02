package com.imooc.ad.dao;

import com.imooc.ad.SponsorApplication;
import com.imooc.ad.entity.AdUser;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 21:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SponsorApplication.class)
public class AdUserDaoTest {

    @Autowired
    AdUserDao adUserDao;

    @Test
    public void testAdUserDao() {
        AdUser adUser = adUserDao.findByUserName("gjs");
        System.out.println(adUser.getId());
    }
}

package com.sunchg.dbdw.mapperTests;

import com.sunchg.dbdw.DBDWApplication;
import com.sunchg.dbdw.dao.OwnerDao;
import com.sunchg.dbdw.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author SunChonggao
 * @Date 2020/8/12 17:27
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DBDWApplication.class)
public class userDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSelect() {
        System.out.println(userDao.selectByUsername("admin"));
    }
}

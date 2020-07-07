package com.sunchg.webservice.MapperTests;

import com.sunchg.webservice.WebserviceApplication;
import com.sunchg.webservice.dao.CommodityDao;
import com.sunchg.webservice.entity.Commodity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author SunChonggao
 * @Date 2020/3/9 20:45
 * @Version 1.0
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = WebserviceApplication.class)
public class commodityTest {
    @Autowired
    private CommodityDao commodityDao;
    @Test
    public void testCommodity(){
        List<Commodity> list = new ArrayList<>();
        list = commodityDao.selectByKeyword("手机");
        for(int i = 0;i < list.size();i++){
           System.out.println(list.get(i));
        }
    }

}

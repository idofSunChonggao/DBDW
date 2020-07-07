package com.sunchg.webservice.service;

/**
 * @Author SunChonggao
 * @Date 2020/3/9 21:39
 * @Version 1.0
 * @Description:业务层
 */

import com.sunchg.webservice.dao.CommodityDao;
import com.sunchg.webservice.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {
    //自动装配bean
    @Autowired
    private CommodityDao commodityDao;
    public List<Commodity> queryAll(){ return  commodityDao.selectAll();}
    public List<Commodity> queryByKeword(String keyword){ return  commodityDao.selectByKeyword(keyword);}
    public Commodity queryById(int id){ return  commodityDao.selectById(id);}

}

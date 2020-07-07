package com.sunchg.webservice.controller;

import com.sunchg.webservice.entity.Commodity;
import com.sunchg.webservice.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author SunChonggao
 * @Date 2020/3/9 20:13
 * @Version 1.0
 * @Description:控制器
 */
@RestController
@RequestMapping("/Commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    //返回所有商品
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Commodity> getAllCommodities() {
        List<Commodity> list = new ArrayList<>();
        list = commodityService.queryAll();
        return list;
    }
    //按关键字搜索商品
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Commodity> searchByKeyword(@RequestParam(value = "keyword")String keyword) {
        List<Commodity> list = new ArrayList<>();
        list = commodityService.queryByKeword(keyword);
        return list;
    }
    //测试
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Commodity searchById() {
        Commodity commodity = commodityService.queryById(1);
        return commodity;
    }

}

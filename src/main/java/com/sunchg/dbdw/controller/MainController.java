package com.sunchg.dbdw.controller;


import com.sunchg.dbdw.entity.Owner;
import com.sunchg.dbdw.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author SunChonggao
 * @Date 2020/8/9 20:13
 * @Version 1.0
 * @Description:控制器
 */
@Controller
@RequestMapping("/demo")
public class MainController {

    private OwnerService ownerService;

    @Autowired
    public MainController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    //显示主页
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Owner> owners = ownerService.queryAll();
        modelAndView.addObject("owners", owners);
        modelAndView.setViewName("/index");
        return modelAndView;
    }
    @RequestMapping(path = "/alterTest", method = RequestMethod.GET)
    public String getAlterPage() {
        return "/alter";
    }
    //篡改
    @RequestMapping(path = "/alter", method = RequestMethod.POST)
    public String alterOwnerInfo(@RequestParam(value = "id")int id,
                                      @RequestParam(value = "car") String car) {

        ownerService.alterCar(id, car);
        return "redirect:/demo/index";
    }
    @RequestMapping(path = "/detect", method = RequestMethod.GET)
    public String getDetectPage(Model model) {
        List<Owner> list = ownerService.queryAll();
        List<Owner> owners = new ArrayList<>();
        for(Owner owner:list){
            if(ownerService.alterDetection(owner)) {
                owners.add(owner);
            }
        }
        if(owners.size() == 0)
            model.addAttribute("result","未检测到篡改");
        else
            model.addAttribute("result","车辆信息被篡改");

        model.addAttribute("owners",owners);
        return "/detect";

    }
    @RequestMapping(path = "/recover", method = RequestMethod.GET)
    public String recover(@RequestParam(value = "id")int id) {
        ownerService.recover(id);
        return "redirect:/demo/detect";
    }
}

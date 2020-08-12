package com.sunchg.dbdw.service;

/**
 * @Author SunChonggao
 * @Date 2020/8/9 21:39
 * @Version 1.0
 * @Description:业务层
 */

import com.sunchg.dbdw.dao.OwnerDao;
import com.sunchg.dbdw.entity.Owner;
import com.sunchg.dbdw.utils.AES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.util.DigestUtils;
@Service
public class OwnerService {

    private OwnerDao ownerDao;

    private final static String key = "test_key";

    @Autowired
    public OwnerService(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public List<Owner> queryAll(){ return ownerDao.selectAll();}
    public Owner queryById(int id){ return ownerDao.selectById(id);}
    public boolean alterCar(int id, String car) { return ownerDao.updateCar(id, car);}
    //使用MD5生成摘要
    //输入：车主信息
    public boolean generateDigest(Owner owner) {
        String info = owner.getName() + owner.getAge() + owner.getDriving() + owner.getCar();
        String digest = DigestUtils.md5DigestAsHex(info.getBytes());
        return ownerDao.updateDigest(owner.getId(), digest);
    }
    //篡改检测
    //检测到篡改返回true,否则返回false
    public boolean alterDetection(Owner owner) {
        String info = owner.getName() + owner.getAge() + owner.getDriving() + owner.getCar();
        String digest = DigestUtils.md5DigestAsHex(info.getBytes());
        return !digest.equals(ownerDao.selectDigestById(owner.getId()));
    }

    //使用AES生成加密信息
    //输入：车主信息
    public boolean generateWatermark(Owner owner) {
        String info = owner.getName() + "," + owner.getAge() + "," + owner.getDriving() + "," + owner.getCar();
        String watermark = AES.AES_Encrypt(info, key, "CBC");
        return ownerDao.updateWatermark(owner.getId(), watermark);
    }

    //恢复车主的信息
    //篡改检测 -> id -> 水印 -> 解密 -> 原始数据
    public boolean recover(int id) {
        Owner owner = ownerDao.selectById(id);
        String watermark = ownerDao.selectWatermarkById(id);
        String info = AES.AES_Decrypt(watermark, key, "CBC");
        String[] infoArray = info.split(",");
        //比对车辆信息
        String car = owner.getCar();
        if(!car.equals(infoArray[infoArray.length - 1]))
            return ownerDao.updateCar(id, infoArray[infoArray.length - 1]);//不相等则恢复
        else
            return false;
    }

}

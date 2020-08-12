package com.sunchg.dbdw.serviceTests;

import com.sunchg.dbdw.DBDWApplication;

import com.sunchg.dbdw.entity.Owner;
import com.sunchg.dbdw.service.OwnerService;
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
@ContextConfiguration(classes = DBDWApplication.class)
public class OwnerTest {
    @Autowired
    private OwnerService ownerService;
    @Test
    public void testGenerate() {
        for(int i = 1; i < 5; i++) {
            Owner owner = ownerService.queryById(i);
            System.out.println("MD5" + ownerService.generateDigest(owner));
            System.out.println("AES" + ownerService.generateWatermark(owner));
        }
    }
    @Test
    public void testRecovery() {
        System.out.println(ownerService.recover(2));
    }
    @Test
    public void testDetection() {
        Owner owner = ownerService.queryById(2);
        System.out.println("篡改检测" + ownerService.alterDetection(owner));
    }
    @Test
    public void testSelect() {

        System.out.println(ownerService.queryAll());
    }


}

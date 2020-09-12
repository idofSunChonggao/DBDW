package com.sunchg.dbdw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * @Author SunChonggao
 * @Date 2020/3/9 20:25
 * @Version 1.0
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Owner {
    private int id;
    private String name;
    private int age;
    private int driving;
    private String car;
    private String digest;
    private String watermark;
}

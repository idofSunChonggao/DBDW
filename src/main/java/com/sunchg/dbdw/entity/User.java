package com.sunchg.dbdw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author Sunchonggao
 * @Date 2020-08-30 21:59
 * @Version 1.0
 * @Description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private int type;
}

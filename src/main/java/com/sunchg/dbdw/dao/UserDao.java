package com.sunchg.dbdw.dao;

import com.sunchg.dbdw.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author SunChonggao
 * @Date 2020-08-30 22:22
 * @Version 1.0
 * @Description：
 */
@Mapper
@Repository
public interface UserDao {
    User selectByUsername(@Param("username")String username);
    User selectById(int userId);
}

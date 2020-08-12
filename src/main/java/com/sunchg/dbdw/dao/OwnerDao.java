package com.sunchg.dbdw.dao;

import com.sunchg.dbdw.entity.Owner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author SunChonggao
 * @Date 2020/3/9 20:29
 * @Version 1.0
 * @Description:数据访问接口
 */

@Mapper
@Repository
public interface OwnerDao {
    List<Owner> selectAll();
    Owner selectById(@Param("id")int id);
    String selectDigestById(@Param("id")int id);
    String selectWatermarkById(@Param("id")int id);
    boolean updateCar(@Param("id")int id, @Param("car")String car);
    boolean updateDigest(@Param("id")int id, @Param("digest")String digest);
    boolean updateWatermark(@Param("id")int id, @Param("watermark")String watermark);
}

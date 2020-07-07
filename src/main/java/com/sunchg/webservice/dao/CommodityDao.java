package com.sunchg.webservice.dao;

import com.sunchg.webservice.entity.Commodity;
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
//标注为Dao
@Repository
public interface CommodityDao {
    List<Commodity> selectAll();
    List<Commodity> selectByKeyword(@Param("keyword")String keyword);
    Commodity selectById(@Param("id")int id);
}

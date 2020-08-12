package com.cwu.emallseckill.dao;

import com.cwu.emallseckill.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderInfoMapper {
    /**添加普通订单信息*/
    int insert(@Param("record") OrderInfo record);

    OrderInfo selectByPrimaryKey(@Param("id") long id);


    /**添加秒杀订单信息*/
    int insertSeletive(@Param("orderInfo") OrderInfo orderInfo);
}

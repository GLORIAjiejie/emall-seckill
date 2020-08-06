package com.cwu.emallseckill.dao;

import com.cwu.emallseckill.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoMapper {

    int insert(@Param("record") OrderInfo record);

    OrderInfo selectByPrimaryKey(@Param("id") long id);

}

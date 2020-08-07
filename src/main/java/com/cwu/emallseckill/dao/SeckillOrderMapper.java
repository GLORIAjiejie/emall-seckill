/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillOrderMapper
 * Author:   min
 * Date:     2020-08-06 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.dao;

import com.cwu.emallseckill.entity.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-06
 * @since 1.0.0
 */
@Mapper
@Repository
public interface SeckillOrderMapper {
    SeckillOrder selectByUserIdAndGoodsId(@Param("userId")long userId,@Param("goodsId")long goodsId);

    int insertSelective(SeckillOrder record);
}

package com.cwu.emallseckill.dao;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {

    /** 添加商品 */
    int insert(@Param("goods") Goods goods);

    /** 根据id删除商品 */
    int deleteByPrimaryKey(@Param("id") Long id);

    /** 根据id修改商品基本信息*/
    int updateByPrimaryKey(@Param("goods") Goods goods);

    /** 根据id修改商品详细信息*/
    int updateByPrimaryKeyWithBLOBs(@Param("goods") Goods goods);

    /** 根据id查询商品信息 */
    Goods selectByPrimaryKey(@Param("id") Long id);

    /** 查询所有参与秒杀获得的商品 */
    List<GoodsBo> selectAllGoods();

    /** 查询秒杀商品详情 */
    GoodsBo getSeckillGoodsBoByGoodsId(@Param("goodsId") long goodsId);

}

package com.yu.ssm.dao;

import com.yu.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    List<Product> findById(String id) throws Exception;

    //查询所有商品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    //添加商品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product) throws Exception;
}

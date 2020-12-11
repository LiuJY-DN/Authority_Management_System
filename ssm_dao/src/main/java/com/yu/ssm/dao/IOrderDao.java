package com.yu.ssm.dao;

import com.yu.ssm.domain.Orders;
import com.yu.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    //@Select("select * from orders")
    //@Results({
    //        @Result(id = true,property = "id",column = "id"),
    //        @Result(property = "orderNum",column = "orderNum"),
    //        @Result(property = "orderTime",column = "orderTime"),
    //        @Result(property = "orderStatus",column = "orderStatus"),
    //        @Result(property = "peopleCount",column = "peopleCount"),
    //        @Result(property = "payType",column = "payType"),
    //        @Result(property = "orderDesc",column = "orderDesc"),
    //        @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yu.ssm.dao.IProductDao.findById")),
    //})
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.yu.ssm.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select = "com.yu.ssm.dao.IProductDao.findById")),
            @Result(column = "id", property = "travellers", many = @Many(select = "com.yu.ssm.dao.ITravellerDao.findByOrderId")),
            @Result(column = "memberId", property = "member", one = @One(select = "com.yu.ssm.dao.IMemberDao.findById")),})
    Orders findById(String orderId) throws Exception;
}

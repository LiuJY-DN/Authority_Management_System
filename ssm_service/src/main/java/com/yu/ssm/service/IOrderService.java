package com.yu.ssm.service;

import com.yu.ssm.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IOrderService {

    //查询所有订单
    //List<Orders> findAll() throws Exception;

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String orderId) throws Exception;
}

package com.yu.ssm.service;

import com.yu.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    //查询所有商品信息
    List<Product> findAll() throws Exception;

    //添加产品
    void add(Product product) throws Exception;
}

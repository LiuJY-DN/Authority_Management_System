package com.yu.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.yu.ssm.dao.IOrderDao;
import com.yu.ssm.domain.Orders;
import com.yu.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    //@Override
    //public List<Orders> findAll() throws Exception {
    //
    //    return orderDao.findAll();
    //}

    //分页查询
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //pageNum是页码值，pageSize是显示几条
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String orderId) throws Exception {
        return orderDao.findById(orderId);
    }
}

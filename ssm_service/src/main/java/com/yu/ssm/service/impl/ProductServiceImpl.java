package com.yu.ssm.service.impl;

import com.yu.ssm.dao.IProductDao;
import com.yu.ssm.domain.Product;
import com.yu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) throws Exception {
        productDao.add(product);
    }
}

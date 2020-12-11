package com.yu.ssm.controller;

import com.yu.ssm.domain.Product;
import com.yu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //查询全部商品
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        System.out.println(productList);
        mv.addObject("productList",productList);
        mv.setViewName("product-list");

        return mv;
    }

    //添加产品
    @RequestMapping("/add.do")
    public String add(Product product) throws Exception {
        productService.add(product);

        return "redirect:findAll.do";
    }

}

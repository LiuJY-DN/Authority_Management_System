package com.yu.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yu.ssm.domain.Orders;
import com.yu.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //查询全部订单，未分页
    //@RequestMapping("/findAll.do")
    //public ModelAndView findAll() throws Exception {
    //
    //    ModelAndView mv = new ModelAndView();
    //    List<Orders> ordersList = orderService.findAll();
    //    System.out.println(ordersList);
    //    mv.addObject("ordersList",ordersList);
    //    //要跳转的页面
    //    mv.setViewName("orders-list");
    //    return mv;
    //}


    //查询全部订单，分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page,size);

        PageInfo pageInfo = new PageInfo(ordersList);

        mv.addObject("pageInfo",pageInfo);
        //要跳转的页面
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
        ModelAndView mv = new ModelAndView();

        Orders orderShow = orderService.findById(orderId);
        mv.addObject("orders",orderShow);
        mv.setViewName("orders-show");
        return mv;
    }



}

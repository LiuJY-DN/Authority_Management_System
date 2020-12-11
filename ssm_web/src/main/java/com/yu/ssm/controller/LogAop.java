package com.yu.ssm.controller;

import net.sf.jsqlparser.statement.select.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect//是一个切面
public class LogAop {

    private Date visitTime;//开始时间
    private Class Clazz;//访问的类
    private Method method;//访问的方法

    //前置通知
    @Before("execution(* com.yu.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp){

    }


    //后置通知
    @After("execution(* com.yu.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){

    }

}

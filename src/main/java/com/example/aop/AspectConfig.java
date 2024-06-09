/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Lenovo
 */
@Configuration
@Aspect
public class AspectConfig {
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Before(value = "execution(* com.example.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info("Inside Before Advice");
    }
    
}

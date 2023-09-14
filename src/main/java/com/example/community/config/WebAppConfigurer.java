package com.example.community.config;

import com.example.community.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 使用 @Configuration 注解的类就可以被 Spring 识别为配置类，并处理该类上的相关功能注解
  @Configuration
  public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    /**
       * 配置不需要拦截和需要拦截的请求
       * @param registry
       */
      //@Override 注解是用来指定方法重写的，只能修饰方法并且只能用于方法重写，不能修饰其它的元素。它可以强制一个子类必须重写父类方法或者实现接口的方法。
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
          //添加不拦截的方法（登入）
          String[] patterns = new String[] {"/*/login"};
          registry.addInterceptor(new SysInterceptor())
                  .addPathPatterns("/**")  //先拦截所有方法
                  .excludePathPatterns(patterns);  //在拦截的方法中剔除掉 patterns 中的方法（不拦截）
      }
  }
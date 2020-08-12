/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WebConfig
 * Author:   min
 * Date:     2020-08-10 21:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.config;

import com.cwu.emallseckill.filter.LoginFilter;
import com.cwu.emallseckill.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.Filter;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-10
 * @since 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor=registry.addInterceptor(authorityInterceptor);

        addInterceptor
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }

    @Bean("myFilter")
    public Filter uploadFilter(){
        return new LoginFilter();
    }

    @Bean
    public FilterRegistrationBean uploadFilterRegistration(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new DelegatingFilterProxy("myFilter"));
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/**");
        return registrationBean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}

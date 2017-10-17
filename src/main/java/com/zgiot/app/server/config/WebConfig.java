package com.zgiot.app.server.config;

import com.zgiot.common.restcontroller.AccessLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/product/images/** 访问都映射到classpath:/product/images/ 目录下
        registry.addResourceHandler("/product/images/**").addResourceLocations("classpath:/product/images/");
        registry.addResourceHandler("/files/**").addResourceLocations("file:D:/uploadFile/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
                Date date = null;
                try {
                    date = sdf.parse(source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        };
    }
}


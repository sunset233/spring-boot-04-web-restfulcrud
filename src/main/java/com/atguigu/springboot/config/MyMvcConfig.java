package com.atguigu.springboot.config;



import com.atguigu.springboot.component.LoginHanderInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ Author: Sunset
 * @ Date: 2020/7/19 0:35
 * @ Version: 1.0
 */

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }
    @Bean//将组件注册在容器中
    public WebMvcConfigurer WebMvcConfiguer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("index");
                registry.addViewController("index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");

            }
        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

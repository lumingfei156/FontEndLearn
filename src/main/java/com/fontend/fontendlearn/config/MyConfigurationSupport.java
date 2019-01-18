package com.fontend.fontendlearn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lulu
 * @since 2018/12/13
 * 默认的静态文件所在文件夹是static
 * 自定义静态文件所在文件夹，改成my
 */
@Configuration
public class MyConfigurationSupport extends WebMvcConfigurationSupport {

    /**
     * 自定义静态文件存放位置
     * @param registry ss
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    /**
     * 将某一访问路径和某个页面绑定，即不通过controller直接访问某个页面
     * @param registry ss
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/xmlHttRequestAttr").setViewName("XMLHttpRequestAttr");
        registry.addViewController("/XMLHttpRequestGet").setViewName("XMLHttpRequestGet");
        registry.addViewController("/xhrLoadEvent").setViewName("xhrLoadEvent");
        registry.addViewController("/xhrProgressEvent").setViewName("xhrProgressEvent");
        super.addViewControllers(registry);
    }

    /**
     *实现拦截器效果
     * @param registry ss
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/userService/goLogin","/login","/static/**").addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
}

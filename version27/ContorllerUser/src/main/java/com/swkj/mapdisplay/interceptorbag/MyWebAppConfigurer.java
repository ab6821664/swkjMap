/*

package com.swkj.mapdisplay.interceptorbag;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

*//*
  @添加拦截
 *//*
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContainerCustomizer()).addPathPatterns("");
        super.addInterceptors(registry);
    }
}*/



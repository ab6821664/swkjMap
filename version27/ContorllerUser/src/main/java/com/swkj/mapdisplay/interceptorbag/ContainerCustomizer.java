/*package com.swkj.mapdisplay.interceptorbag;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

*//*
   @配置拦截器
   @拦截404，和500页面
 *//*
@Component
@Controller
public class ContainerCustomizer extends HandlerInterceptorAdapter {
    private List<Integer> errorCodeList = Arrays.asList(404, 500);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (errorCodeList.contains(response.getStatus())) {
            response.sendRedirect("/errorpage/" + response.getStatus());
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}*/

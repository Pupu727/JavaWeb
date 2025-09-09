package com.lirui.Filter;

import com.lirui.ultis.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.判断是否登录
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login")){
            log.info("登录请求,直接放行");
            filterChain.doFilter(request,response);
            return;
        }
        //2.判断是否有token
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("token为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //3.判断token是否有效
        try{
            JwtUtils.parseToken(token);
        }catch (Exception e){
            log.info("token无效");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //4.放行
        filterChain.doFilter(request,response);
        log.info("token有效,放行");
    }
}

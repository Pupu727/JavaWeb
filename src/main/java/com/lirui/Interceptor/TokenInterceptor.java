package com.lirui.Interceptor;

import com.lirui.ultis.CurrentHolder;
import com.lirui.ultis.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //2.判断是否有token
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("token为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //3.判断token是否有效
        try{
            Map<String, Object> info = JwtUtils.parseToken(token);
            Integer id = Integer.parseInt(info.get("id").toString());
            CurrentHolder.setCurrentId(id);
        }catch (Exception e){
            log.info("token无效");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //4.放行
        return true;
    }
}

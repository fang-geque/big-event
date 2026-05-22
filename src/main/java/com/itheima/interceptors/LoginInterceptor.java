package com.itheima.interceptors;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 验证token
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            //把业务数据存到ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true; // 放行
        } catch (Exception e) {
            //http 响应状态码为401
            response.setStatus(401);
            return false; // 不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, @Nullable Exception ex) throws Exception {
        // 清空拦截器
        ThreadLocalUtil.remove();
    }
}

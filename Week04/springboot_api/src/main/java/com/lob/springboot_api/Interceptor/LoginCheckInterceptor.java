package com.lob.springboot_api.Interceptor;

import com.lob.springboot_api.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    // 1분
    private final int MINUTE = 60;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        //System.out.println("Login Check preHandle is Worked!");
        //세션이 NULL인지 확인
        if(session == null) {
            response.sendRedirect("/");
            return false;
        }

        //세션의 key를 통하여서 세션 값이 저장되었는지 확인
        UserDto user = (UserDto) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/");
            return false;
        }

        session.setMaxInactiveInterval(MINUTE*30); // 30분
       return true;
    }
}

package com.learnbasicjava.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class LoggerInterceptor implements HandlerInterceptor {

    // pre appearance when before controller excutes
    // post appearance when controller excutes finish
    // afterComplete when view excutes finish handle afterComplete before response
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Access at" + new Date());
        return true;
    }

}

package com.learnbasicjava.interceptor;

import com.learnbasicjava.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LayoutInterceptor implements HandlerInterceptor {

    @Autowired
    CategoryDAO dao;

    // pre appearance when before controller excutes
    // post appearance when controller excutes finish
    // afterComplete when view excutes finish handle afterComplete before response
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        request.setAttribute("cate", dao.findAll());
    }

}

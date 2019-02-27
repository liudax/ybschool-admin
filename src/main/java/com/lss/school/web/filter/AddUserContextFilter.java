package com.lss.school.web.filter;

import com.lss.school.entity.UserInfo;
import com.lss.school.util.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Magic
 * @date 14:48 2018/3/30
 * @description
 */
@Slf4j
@Order(1)
@Component
public class AddUserContextFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
        UserThreadLocal.getInstance().set(userInfo);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

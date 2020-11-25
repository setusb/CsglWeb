package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author setusb
 * @version 1.0
 * @date 2020/11/24 18:04
 */
public class EncodingFilter implements Filter {
    public EncodingFilter() {
        System.out.println("过滤器构造");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("过滤器初始化");
    }
}
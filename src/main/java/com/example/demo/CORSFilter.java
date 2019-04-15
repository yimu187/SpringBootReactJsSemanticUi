package com.example.demo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class CORSFilter implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println(" CORSFilter begin");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "Origin, Accept, X-Requested-With, Content-Type, Content-Length, X-Requested-With, Cache-Control, x-decompressed-content-length, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain.doFilter(httpServletRequest, httpServletResponse);

        System.out.println(" CORSFilter end");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

}
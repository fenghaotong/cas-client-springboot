package com.cas.springboot.config;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceProxyServletConfiguration {
    @Value("${service.url}")
    private String serviceUrl;

    @Value("${location}")
    private String urlMappings;

    @Bean
    public ServletRegistrationBean servletRegistrationBaiduBean(){
        ServletRegistrationBean baidu= new ServletRegistrationBean(new ProxyServlet(), urlMappings);
        baidu.setName("service");
        baidu.addInitParameter("targetUri", serviceUrl);
        baidu.addInitParameter(ProxyServlet.P_LOG, "false");
        return baidu;
    }
}


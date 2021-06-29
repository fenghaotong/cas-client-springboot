package com.cas.springboot.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CasUrlPatternConfig {

    @Value("${cas.server-url-prefix}")
    private String casServerUrlPrefix;

    @Value("${cas.server-login-url}")
    private String casServerLoginUrl;

    @Value("${cas.client-host-url}")
    private String casClientHostUrl;

    @Value("${cas-ignore-pattern}")
    private String casIgnorePattern;

    @Value("${cas-redirectAfterValidation}")
    private String redirectAfterValidation;

    @Value("${cas-useSession}")
    private String useSession;

    @Value("${cas-authn_method}")
    private String authn_method;

    /**
     * 登出过滤器
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SingleSignOutFilter());
        registration.addUrlPatterns("/*");

        registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);

        registration.setOrder(1);
        return registration;
    }
    /**
     * description:认证过滤器
     * ignoreUrlPatternType 使用CAS现成的正则表达式过滤策略
     */
    @Bean
    public FilterRegistrationBean authenticationFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
        registration.addUrlPatterns("/*");

        registration.addInitParameter("casServerLoginUrl", casServerLoginUrl);
        registration.addInitParameter("serverName", casClientHostUrl);
        //配置文件中设置要过滤拦截的路径
        registration.addInitParameter("ignorePattern", casIgnorePattern);
        registration.addInitParameter("ignoreUrlPatternType", "org.jasig.cas.client.authentication.RegexUrlPatternMatcherStrategy");

        registration.setOrder(1);
        return registration;
    }

    /**
     * description:ticket验证过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean ticketValidationFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
        registration.addUrlPatterns("/*");

        registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
        registration.addInitParameter("serverName", casClientHostUrl);
        registration.addInitParameter("encoding", "UTF-8");
        registration.addInitParameter("redirectAfterValidation", redirectAfterValidation);
        registration.addInitParameter("useSession", useSession);
        registration.addInitParameter("authn_method", authn_method);
        registration.setOrder(1);
        return registration;
    }

    /**
     * wrapper过滤器
     */
    @Bean
    public FilterRegistrationBean wrapperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestWrapperFilter());

        registration.addUrlPatterns("/*");

        registration.setOrder(1);
        return registration;
    }

}



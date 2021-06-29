package com.cas.springboot.bean;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConfig {
    @Value("${cas.server-url-prefix}")
    private String casServerUrl;

    @Value("${cas.server-login-url}")
    private String casServerLoginUrl;

    @Value("${caslogout}")
    private String casServerLogoutUrl;

    @Value("${cas.cas.client-host-url}")
    private String casClientUrl;

    @Value("${cas.cas.validation-type}")
    private String casValidationType;

    @Value("${service.url}")
    private String serviceUrl;

    public String getCasServerUrl() {
        return casServerUrl;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public String getCasClientUrl() {
        return casClientUrl;
    }

    public String getCasValidationType() {
        return casValidationType;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getCasServerLogoutUrl() {
        return casServerLogoutUrl;
    }
}

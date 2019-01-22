package com.oauth.sso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;

/**
 * url白名单处理 application.properties 中配置需要放权的url白名单
 * <p>
 * Created by xuh
 * DATE 2019/1/23 1:12.
 * version 1.0
 */
@ConfigurationProperties(prefix = "security.oauth2")
public class PermitUrlProperties {

    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {"/**/actuator/health", "/**/actuator/env", "/**/actuator/metrics/**",
            "/**/actuator/trace", "/**/actuator/dump", "/**/actuator/jolokia", "/**/actuator/info",
            "/**/actuator/logfile", "/**/actuator/refresh", "/**/actuator/flyway", "/**/actuator/liquibase",
            "/**/actuator/heapdump", "/**/actuator/loggers", "/**/actuator/auditevents", "/**/actuator/env/PID",
            "/**/actuator/jolokia/**", "/**/actuator/archaius/**", "/**/actuator/beans/**", "/**/actuator/httptrace",
            "/**/v2/api-docs/**", "/**/swagger-ui.html", "/**/swagger-resources/**", "/**/webjars/**", "/**/druid/**",
            "/**/actuator/hystrix.stream", "/**/actuator/hystrix.stream**/**", "/**/turbine.stream", "/**/turbine.stream**/**",
            "/**/hystrix", "/**/hystrix.stream", "/**/hystrix/**", "/**/hystrix/**/**", "/**/proxy.stream/**", "/**/favicon.ico"};

    private String[] ignored;

    public String[] getIgnored() {
        if (ignored == null || ignored.length == 0) {
            return ENDPOINTS;
        }

        Set<String> set = new HashSet<>(Arrays.asList(ENDPOINTS));
        set.addAll(Arrays.asList(ignored));

        return (String[]) set.toArray();
    }

    public void setIgnored(String[] ignored) {
        this.ignored = ignored;
    }
}

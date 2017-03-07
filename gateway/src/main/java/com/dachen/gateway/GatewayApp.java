package com.dachen.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

import com.dachen.gateway.filter.AccessFilter;
import com.dachen.gateway.filter.SignFilter;

@EnableZuulProxy
@SpringCloudApplication
public class GatewayApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApp.class).web(true).run(args);
	}
	
	@Bean
	public AccessFilter newAccessFilter() {
		return new AccessFilter();
	}
	@Bean
	public SignFilter newSignFilter() {
		return new SignFilter();
	}
	
	@RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}

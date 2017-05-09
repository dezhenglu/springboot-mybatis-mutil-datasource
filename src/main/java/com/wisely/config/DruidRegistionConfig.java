package com.wisely.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidRegistionConfig {
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		//拦截路径
		servletRegistrationBean.addUrlMappings("/druid/*");
		// 设置访问白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		// 设置访问黑名单
		// reg.addInitParameter("deny", "");
		// 设置是否允许清空计数
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		// 登录用户名
		servletRegistrationBean.addInitParameter("loginUsername", "ludzh");
		// 登录密码
		servletRegistrationBean.addInitParameter("loginPassword", "ludzh");
		
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		//拦截路径
		filterRegistrationBean.addUrlPatterns("/*");
		//排除指定路径
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		
		return filterRegistrationBean;
	}
}
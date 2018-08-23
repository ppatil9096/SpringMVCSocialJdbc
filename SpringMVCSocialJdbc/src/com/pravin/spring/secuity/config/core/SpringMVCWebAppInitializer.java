package com.pravin.spring.secuity.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pravin.spring.secuity.config.LoginApplicationConfig;

public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { LoginApplicationConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] { LoginApplicationConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }
}

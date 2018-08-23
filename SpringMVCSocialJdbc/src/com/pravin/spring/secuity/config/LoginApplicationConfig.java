package com.pravin.spring.secuity.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan({ "com.pravin.spring.*" })
@Import(value = { LoginSecurityConfig.class })
@PropertySource("classpath:db.properties")
public class LoginApplicationConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
	// Load property in message/validator.properties
	rb.setBasenames(new String[] { "messages/validator" });
	return rb;
    }

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
	dataSource.setUrl(env.getProperty("ds.url"));
	dataSource.setUsername(env.getProperty("ds.username"));
	dataSource.setPassword(env.getProperty("ds.password"));
	return dataSource;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);

	return transactionManager;
    }
}

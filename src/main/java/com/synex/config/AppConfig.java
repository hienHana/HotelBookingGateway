package com.synex.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@PropertySource(value="classpath:db.properties")
public class AppConfig {
	@Autowired Environment en;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;

	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(en.getProperty("dbUrl"));
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUsername(en.getProperty("dbUser"));
		dataSource.setPassword(en.getProperty("dbPassword"));
		return dataSource;		
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.synex.domain");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaProperties(jpaProperties());
		
		return entityManagerFactory;
	}
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		/* sessionFactory.setAnnotatedClasses(Hotel.class); */
		sessionFactory.setPackagesToScan("com.synex.domain");
		sessionFactory.setHibernateProperties(jpaProperties());
		return sessionFactory;
	}
	
	public Properties jpaProperties(){
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dilect", "org.hibernate.dialect.Oracle10gDialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // hbm = hibernate mapping, ddl = data definition language
		
		return jpaProperties;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
		
	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/WEB-INF/messages/message");
		return messageSource;
		
	}

}

package com.assign.project.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.assign.project")
@PropertySource({"classpath:persistance-mysql.properties"})
public class DemoAppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

	@Bean
	public DataSource myDataSource()
	{
	
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		
		try
		{
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));

		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		
		return myDataSource;
	}
	
	private int getIntProperty(String propName)
	{
		String propValue = env.getProperty(propName);
		int intPropValue = Integer.parseInt(propValue);
		return intPropValue;
	}
	
	// Creating a SessionFactory Bean
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	private Properties getHibernateProperties()
	{
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	// Creating a Transaction Manager Bean 
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}

}

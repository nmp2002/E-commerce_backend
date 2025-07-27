package com.ttisv.springbootwildfly.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author doanhtd
 * @version 0.0.1
 * @since 2018/06/04
 * 
 *        Class cấu hình hibernate
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.ttisv.dao"), @ComponentScan("com.ttisv.service") })
public class HibernateConfig {

	@Autowired
	private ApplicationContext context;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();


		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@192.168.1.251:1521/orcl");
		dataSource.setUsername("SMARTDO");
		dataSource.setPassword("smartdo2022");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		//sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		sessionFactory.setPackagesToScan("com.ttisv.bean");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	public final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		hibernateProperties.setProperty("hibernate.default_schema", "SMARTDO");
		hibernateProperties.setProperty("hibernate.show_sql", "false");
		hibernateProperties.setProperty("hibernate.connection.release_mode", "auto");
		hibernateProperties.setProperty("hibernate.connection.autoReconnect", "true");
		hibernateProperties.setProperty("hibernate.c3p0.min_size", "5");
		hibernateProperties.setProperty("hibernate.c3p0.max_size", "50");
		hibernateProperties.setProperty("hibernate.c3p0.acquire_increment", "150");
		hibernateProperties.setProperty("hibernate.c3p0.max_statements", "150");
		hibernateProperties.setProperty("hibernate.jdbc.batch_size", "1000");
		return hibernateProperties;
	}

}

package com.example;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
	@Value("${jpa.url}")
	private String URL;
	@Value("${jpa.username}")
	private String username;
	@Value("${jpa.password}")
	private String  password;
	@Value("${jpa.driver}")
	private String databaseDriver;
	
	@Bean(name="entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerBean(){
		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.example.model");
		JpaVendorAdapter jp=new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jp);
		em.setJpaProperties(properties());
		return em;
	}
	
	@Bean 
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(databaseDriver);
		ds.setUrl(URL);
		ds.setUsername(username);
		ds.setPassword(password);
       return ds;
	}
	
	@Bean(name="serv")
	public PlatformTransactionManager txnManager(EntityManagerFactory em)
	{
		JpaTransactionManager jtm=new JpaTransactionManager(em);
		return jtm;
	}
	
	private Properties properties(){
		Properties ps=new Properties();
		ps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		ps.setProperty("hibernate.hbm2ddl.auto", "create");
		ps.setProperty("hibernate.show_sql", "true");
		ps.setProperty("hibernate.format_sql", "true");
		return ps;
	}
}


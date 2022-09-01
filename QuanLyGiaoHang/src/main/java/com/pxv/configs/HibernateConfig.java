/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxv.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

/**
 *
 * @author Admin
 */
@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        
        sessionFactory.setPackagesToScan("com.pxv.pojos");
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        
       return sessionFactory; 
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));
        
        return dataSource;
    }
    
    public Properties hibernateProperties(){
        Properties props = new Properties();
        
        props.setProperty(SHOW_SQL, env.getProperty("hibernate.showSql"));
        props.setProperty(DIALECT, env.getProperty("hibernate.dialect"));
        
        return props;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        
        return transactionManager;
    }
}

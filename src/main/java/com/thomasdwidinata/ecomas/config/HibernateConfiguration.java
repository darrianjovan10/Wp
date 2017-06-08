package com.thomasdwidinata.ecomas.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author thomasdwidinata
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.thomasdwidinata.ecomas"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
    
    @Autowired
    public Environment env;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"com.thomasdwidinata.ecomas.models"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    public Properties hibernateProperties()
    {
        Properties p = new Properties();
        p.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        p.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        p.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        return p;
    }
    
    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s)
    {
        HibernateTransactionManager txMan = new HibernateTransactionManager();
        txMan.setSessionFactory(s);
        return txMan;
    }
}

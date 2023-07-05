package com.nucleus.config;

import com.nucleus.dao.CustomerTempDao;
import com.nucleus.model.entity.CustomerTemp;
import com.nucleus.model.entity.CustomerTempMaster;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.nucleus")
public class AppConfig {


    @Bean
    public CustomerTempDao getDao(){
        CustomerTempDao customerTempDao = new CustomerTempDao();
        return customerTempDao;
    }

    @Bean
    public DataSource securityDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.1.50.198:1535/nsbt19c");
        dataSource.setUsername("sh");
        dataSource.setPassword("sh");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean mysessionfactory=new LocalSessionFactoryBean();
        mysessionfactory.setDataSource(securityDataSource());
        mysessionfactory.setAnnotatedClasses(CustomerTempMaster.class, CustomerTemp.class);

        Properties hibernateProperties= new Properties();
// hibernateProperties.setProperty("hibernate.hbm2ddl.auto","create");
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.setProperty("hibernate.show_sql","true");
        hibernateProperties.setProperty("flushModeName", "FLUSH_AUTO");

        mysessionfactory.setHibernateProperties(hibernateProperties);
        return mysessionfactory;
    }

    @Bean
    public HibernateTemplate getTemplate(){
        HibernateTemplate template= new HibernateTemplate();
        SessionFactory sessionFactory = getSessionFactory().getObject();
        template.setSessionFactory(sessionFactory);
        return template;
    }


    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager= new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(1024000);
        return resolver;
    }


}
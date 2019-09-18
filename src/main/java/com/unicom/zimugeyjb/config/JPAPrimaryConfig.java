package com.unicom.zimugeyjb.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 10:05 <br/>
 * @Author: yangjiabin
 */
@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(
        basePackages = "com.unicom.zimugeyjb.jpadao.testdbjpa",//设置Repository所在位置
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "transactionManager"
)
public class JPAPrimaryConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;


    @Primary
    @Bean(name = "primaryDataSourceProperties")
    @Qualifier("primaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "primaryDataSource" ,initMethod = "init",destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(primaryDataSourceProperties().getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(primaryDataSourceProperties().getPassword());
        mysqlXADataSource.setUser(primaryDataSourceProperties().getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("primary");
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return xaDataSource;
    }


    @Primary
    @Bean(name = "primaryEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() throws Throwable{

        HashMap<String ,Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform",AtomikosJtaPlateform.class.getName());
        properties.put("javax.persistence.transactionType","JTA");
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(primaryDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        //这里要修改主数据源的扫描包   pojo  Entity所在目录
        entityManager.setPackagesToScan("com.unicom.zimugeyjb.pojo");
        entityManager.setPersistenceUnitName("primaryPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }



}

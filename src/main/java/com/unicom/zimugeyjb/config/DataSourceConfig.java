package com.unicom.zimugeyjb.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 10:23 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class DataSourceConfig {

    @Bean(initMethod = "init", destroyMethod = "close",name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDataSource(){
        return  new AtomikosDataSourceBean();
    }

    @Bean(initMethod = "init", destroyMethod = "close",name = "secondaryDataSource")
    @Qualifier("secondarydb")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource(){
        return new AtomikosDataSourceBean();
    }


//    @Bean(name = "primaryJdbcTemplate")
    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


//    @Bean(name = "secondaryJdbcTemplate")
    @Bean
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}

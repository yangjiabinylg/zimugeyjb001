package com.unicom.zimugeyjb.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 16:14 <br/>
 * @Author: yangjiabin
 */
@Configuration
@MapperScan(
        //到层接口文件
        basePackages = "com.unicom.zimugeyjb.dao.db2",
        sqlSessionTemplateRef = "secondarySqlSessionTemplate"
)
public class SecondaryDataSourceConfig {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondarySqlSessionFactory" )
    public SqlSessionFactory testSqlSesionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //这里设置xml扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws  Exception{
        return  new SqlSessionTemplate(sqlSessionFactory);
    }


}

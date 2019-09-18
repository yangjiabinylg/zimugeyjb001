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
        basePackages = "com.unicom.zimugeyjb.dao.db1",
        sqlSessionTemplateRef = "primarySqlSessionTemplate"
)
public class PrimaryDataSourceConfig {

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primarySqlSessionFactory" )
    @Primary
    public SqlSessionFactory testSqlSesionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //这里设置xml扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws  Exception{
        return  new SqlSessionTemplate(sqlSessionFactory);
    }


}

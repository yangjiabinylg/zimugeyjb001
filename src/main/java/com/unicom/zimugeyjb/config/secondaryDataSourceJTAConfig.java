package com.unicom.zimugeyjb.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/19 9:20 <br/>
 * @Author: yangjiabin
 */
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@MapperScan(
        //到层接口文件   dao层的接口
        basePackages = "com.unicom.zimugeyjb.dao.db2",
        sqlSessionTemplateRef = "secondarySqlSessionTemplate"
)
public class secondaryDataSourceJTAConfig {

    @Bean(name = "secondaryDataSource")
    /**
     * 读取yml文件的配置
     */
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource(){
        //AtomikosDataSourceBean   里面定义的字段和yml文件中定义的数据库连接属性要一模一样
        return new AtomikosDataSourceBean();
    }


    @Bean("secondarySqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory
            (@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mapper接口文件和xml不在同一个目录里面这里配置   资源路径
        //这里设置xml扫描路径
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        //mapper接口文件的扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage("com.unicom.zimugeyjb.dao.db2");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("secondarySqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}

package com.unicom.zimugeyjb.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 19:49 <br/>
 * @Author: yangjiabin
 */
@Configuration
@EnableTransactionManagement
//事务管理器都是这个模板
public class XATransactionManagerConfig {

    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws Throwable{
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }

    @Bean(name = "atomikosTransactionManager" ,initMethod = "init" ,destroyMethod = "close")
    public TransactionManager atomikosTransactionManager() throws Throwable{
        UserTransactionManager userTransactionManager =new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }


    @Bean(name = "transactionManager")
    @DependsOn({"userTransaction","atomikosTransactionManager"})
    public PlatformTransactionManager transactionManager() throws Throwable{
        return new JtaTransactionManager(userTransaction(),atomikosTransactionManager());
    }



}

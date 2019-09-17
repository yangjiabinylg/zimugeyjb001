package com.unicom.zimugeyjb.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 11:19 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class TransactionManagerConfig {

    @Bean
    public UserTransaction userTransaction() throws SystemException {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }

    @Bean(name = "atomikosTransactionManager" ,initMethod = "init" ,destroyMethod = "close")
    public TransactionManager atomikosTransactionManager() throws Throwable{
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }


    @Bean(name = "transactionManager")
    @DependsOn({"userTransaction","atomikosTransactionManager"})
    public PlatformTransactionManager transactionManager() throws Throwable{
        UserTransaction userTransaction = userTransaction() ;
        //JtaTransactionManager这个来统一管理事务
        JtaTransactionManager manager = new JtaTransactionManager(userTransaction, atomikosTransactionManager());
        return manager;
    }



}

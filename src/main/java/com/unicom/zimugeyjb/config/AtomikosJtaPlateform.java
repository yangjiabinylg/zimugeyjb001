package com.unicom.zimugeyjb.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/18 9:24 <br/>
 * @Author: yangjiabin
 */
//分布式事务  需要
public class AtomikosJtaPlateform extends AbstractJtaPlatform {

    private static final long serialVersionUID = 1L;

    static TransactionManager transactionManager;

    static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return transaction;
    }
}

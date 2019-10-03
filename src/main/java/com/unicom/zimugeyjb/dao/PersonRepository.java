package com.unicom.zimugeyjb.dao;

import com.unicom.zimugeyjb.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/3 21:28 <br/>
 * @Author: yangjiabin
 */
public interface PersonRepository extends CrudRepository<Person,String> {

    //  继承CrudRepository,获取基本的CRUD操作

}

package com.unicom.zimugeyjb.redis;

import com.sun.corba.se.impl.orb.PropertyOnlyDataCollector;
import com.unicom.zimugeyjb.dao.PersonRepository;
import com.unicom.zimugeyjb.model.Address;
import com.unicom.zimugeyjb.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/3 21:30 <br/>
 * @Author: yangjiabin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test(){
        //存到数据库
        Person person = new Person("yangjiabin2","台州2");
        person.setAddress(new Address("杭州2","中国2"));
        personRepository.save(person);

        //从数据库拿出来
        Optional<Person> optionalPerson = personRepository.findById(person.getId());
        Person person1 = optionalPerson.get();
        long count = personRepository.count();
        int i = 0;
        //personRepository.delete(person);

    }

    @Test
    public void testDelete(){
        personRepository.deleteById("1f3ff1e0-591c-46ed-a7e2-6c120c121ae4");
    }

}

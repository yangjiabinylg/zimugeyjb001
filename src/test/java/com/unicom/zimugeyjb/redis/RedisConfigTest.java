package com.unicom.zimugeyjb.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.zimugeyjb.model.Address;
import com.unicom.zimugeyjb.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/10/3 20:19 <br/>
 * @Author: yangjiabin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *    可以直接注入，就不用redisTemplate间接获取对象了
    @Autowired
    private RedisTemplate redisTemplate;   */

    @Resource(name = "redisTemplate")
    private ValueOperations<String ,Object> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String,String,Object> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String,Object> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String,Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String,Object> zSetOperations;


    @Test
    public void testValueObj() throws Exception{

        Person person = new Person("yang","jiabin");
        person.setAddress(new Address("杭州","中国"));
        /**    可以直接注入，就不用redisTemplate间接获取对象了     */
        //ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        /**   10秒后消失   */
        valueOperations.set("player:1",person,10, TimeUnit.SECONDS);
        //  不写时间就是永久存储
        valueOperations.set("player:yongyuan",person);


        Person getBack = (Person) valueOperations.get("player:yongyuan");
         Person getBack2 = (Person) valueOperations.get("player:1");
        System.out.println(getBack2);
    }


    @Test
    public void testSetOperation() throws Exception{

        Person person = new Person("yang","jiabin");
        Person person2 = new Person("yang2","jiabin2");
        person.setAddress(new Address("杭州","中国"));
        person2.setAddress(new Address("杭州2","中国2"));

        setOperations.add("playerset",person,person2);

        Set<Object> result = setOperations.members("playerset");

        System.out.println(result);

    }


    @Test
    public void testHashOperation() throws Exception{

        Person person = new Person("yang","jiabin");
        person.setAddress(new Address("杭州","中国"));

        hashOperations.put("hash:player","firstname",person.getFirstName());
        hashOperations.put("hash:player","lastname",person.getLastName());
        hashOperations.put("hash:player","address",person.getAddress());

        String firstname = (String) hashOperations.get("hash:player","firstname");

        System.out.println(firstname);

    }




    @Test
    public void testListOperation() throws Exception{

        Person person = new Person("yang","jiabin");
        Person person2 = new Person("yang2","jiabin2");
        Person person3 = new Person("yang3","jiabin3");

        person.setAddress(new Address("杭州","中国"));
        person2.setAddress(new Address("杭州2","中国2"));
        person3.setAddress(new Address("杭州3","中国3"));

        listOperations.leftPush("list:player",person);
        listOperations.leftPush("list:player",person2);
        listOperations.leftPush("list:player",person3);

        Person result = (Person) listOperations.leftPop("list:player");

        System.out.println(result);

    }


    /**
     *   上面的hash操作每个类属性就set一下   100个属性set100编吗
     *   统一操作一下
     */
    @Resource(name = "redisTemplate")
    private HashOperations<String,String,Object> jacksonHashOperations;
    private HashMapper<Object,String,Object> jackson2HashMapper = new Jackson2HashMapper(false);
    @Test
    public void testHashPutAll(){

        Person person = new Person("yang5","jiabin5");
        person.setId("1");
        person.setAddress(new Address("杭州5","中国5"));

        //将对象以hash的形式放入数据库
        Map<String,Object> mapperHash = jackson2HashMapper.toHash(person);
        jacksonHashOperations.putAll("playerqq"+person.getId(),mapperHash);

        //将对象从数据库取出来
        Map<String, Object> loaderHash = jacksonHashOperations.entries("playerqq" + person.getId());
        Object map = jackson2HashMapper.fromHash(loaderHash);
        Person getBack = new ObjectMapper().convertValue(map, Person.class);
        Assert.assertEquals(person.getFirstName(),getBack.getFirstName());


    }

}

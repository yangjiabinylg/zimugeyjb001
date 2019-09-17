package com.unicom.zimugeyjb.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 14:34 <br/>
 * @Author: yangjiabin
 */
public class DozerUtils {

    //list<pojo>  --> list<vo>
    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List<T> mapList(Collection sourceList,Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for(Iterator iterator = sourceList.iterator();iterator.hasNext();){
            Object sourceObject = iterator.next();
            Object destinationObject = dozerBeanMapper.map(sourceObject,destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }



}

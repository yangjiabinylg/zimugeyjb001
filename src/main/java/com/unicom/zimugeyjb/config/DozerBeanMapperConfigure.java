package com.unicom.zimugeyjb.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 14:30 <br/>
 * @Author: yangjiabin
 */
@Configuration
public class DozerBeanMapperConfigure {

    @Bean
    public DozerBeanMapper mapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }


}

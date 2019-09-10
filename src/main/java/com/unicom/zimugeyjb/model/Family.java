package com.unicom.zimugeyjb.model;

import com.unicom.zimugeyjb.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/10 15:26 <br/>
 * @Author: yangjiabin
 */
@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.yml"},factory = MixPropertySourceFactory.class)
public class Family {

    //@Value("${family.family-name}")
    //@NotEmpty
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;


}

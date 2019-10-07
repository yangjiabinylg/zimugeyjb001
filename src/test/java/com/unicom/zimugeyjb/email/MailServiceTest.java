package com.unicom.zimugeyjb.email;

import com.unicom.zimugeyjb.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Resource
    MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1091947832@qq.com","普通文本邮件","普通文本邮件内容测试");
    }
}
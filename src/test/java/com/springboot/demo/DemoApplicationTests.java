package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private MailService mailService;
    @Test
    public void contextLoads() throws Exception{
        //mailService.sendSimpleMaile("383179870@qq.com","测试简单邮件","hello , this is a test mail.");
        String filepath="D:\\微信\\WeChat\\WeChat Files\\qiudezangli\\FileStorage\\File\\2019-02\\记录.txt";
        mailService.sendAttachmentsMail("383179870@qq.com","测试带附件邮件","test send maile with file.",filepath);
    }

}

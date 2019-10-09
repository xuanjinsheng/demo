package com.xjs.demo.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.logging.Logger;

@RestController
@Api(value = "TestMailController", tags = {"邮件发送"})
public class TestEmail {

    @Autowired
    private JavaMailSender jms;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Value("${spring.mail.username}")
    private String Sender;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ApiOperation(value = "欢迎语发送邮件", httpMethod = "GET", produces = "application/json")
    public Object sendEmail(){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送者
        mailMessage.setFrom("xuanjinshengz@126.com");
        //接受者
        mailMessage.setTo("961692500@qq.com");
        //邮件标题
        mailMessage.setSubject("欢迎光临");
        //邮件内容
        mailMessage.setText("感谢你的到来！！！！！");
        jms.send(mailMessage);
        logger.info("发送邮件");
        return "发送成功";
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    @ApiOperation(value = "操作成功邮件", httpMethod = "GET")
    public void send(){
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo("961692500@qq.com");
            helper.setSubject("我家宝宝");
            helper.setText("宝宝的图片");
            //读取静态图片
            FileSystemResource file = new FileSystemResource(new File("D:/project/demo/demo/src/main/resources/static/image/YY.jpg"));
            //加入邮件
            helper.addAttachment("图片jpg",file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        jms.send(message);
        logger.info("操作成功邮件");
    }
}

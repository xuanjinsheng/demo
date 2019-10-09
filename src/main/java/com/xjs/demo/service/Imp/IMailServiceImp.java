package com.xjs.demo.service.Imp;

import com.xjs.demo.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class IMailServiceImp implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendSimpleMail(String to, String subject, String content) {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {

    }
}

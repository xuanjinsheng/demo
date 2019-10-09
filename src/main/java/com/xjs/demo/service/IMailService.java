package com.xjs.demo.service;

public interface IMailService {

    /**
     * 发送普通邮件
     * @param to
     * @param subject
     * @param content
     */
     void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html邮件
     * @param to
     * @param subject
     * @param content
     */
     void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
     void sendAttachmentsMail(String to, String subject, String content, String filePath);
}

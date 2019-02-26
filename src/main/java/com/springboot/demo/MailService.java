package com.springboot.demo;

public interface MailService {
    /**
     * 发送简单邮件
     * @param sendTo 邮件地址
     * @param title 邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMaile(String sendTo,String title,String content);

    /**
     *
     * @param to 邮件发送地址
     * @param subject 邮件标题
     * @param content 邮件内容
     * @param filePath 附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);
}

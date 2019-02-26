package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailServiceImp implements MailService{
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;
    @Override
    public void sendSimpleMaile(String to, String subject, String content){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try{
            mailSender.send(simpleMailMessage);
            System.out.println("邮件发送成功！");
        }catch (Exception e){
            System.out.println("邮件发送失败！");
        }
    }
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath){
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try{
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);
            FileSystemResource file=new FileSystemResource(new File(filePath));
            String filename=filePath.substring(filePath.lastIndexOf(File.separator)+1);
            mimeMessageHelper.addAttachment(filename,file);
            System.out.println("filename:"+filename+"；filepath:"+filePath);
            mailSender.send(mimeMessage);
            System.out.println("邮件发送成功");
        }catch (Exception e){
            System.out.println("邮件发送失败");
        }
    }
}

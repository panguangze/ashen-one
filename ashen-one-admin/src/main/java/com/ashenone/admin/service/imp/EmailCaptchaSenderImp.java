package com.ashenone.admin.service.imp;

import com.ashenone.admin.service.CaptchaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Create by panguangze on 2019/11/5
 */
@Slf4j
@Service
public class EmailCaptchaSenderImp implements CaptchaSender {
    @Autowired
    private MailSender mailSender;
    @Value("{$spring.mail.username}")
    private String from;
    @Override
    public void sendCaptcha(String receiver, String captcha) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(receiver);
        message.setText(captcha);
        try {
            mailSender.send(message);
            log.info("验证码邮件已经发送");
        } catch (Exception e) {
            log.error("发送邮件邮件时发生异常！", e);
        }
    }
}

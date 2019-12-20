package com.ashenone.admin.service;

/**
 * Create by panguangze on 2019/11/5
 * 信息发送服务接口，目前只实现邮件发送
 */
public interface CaptchaSender {
    /**
     * 发送邮件
     * @param receiver 收件人
     * @param captcha 验证码
     */
    public void sendCaptcha(String receiver, String captcha);
}

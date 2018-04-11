package com.genvict.message.dao;

import javax.mail.MessagingException;

public interface MailService {
	
	//发送string格式邮件
	public void sendSimpleMail(String to, String subject, String content);
	
	//发送html格式邮件
	public void sendHtmlMail(String to, String subject, String content)  throws MessagingException;
	
	//发送带附件的邮件
	public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException;
	
	//发送带静态资源的邮件
	//邮件中的静态资源一般就是指图片
	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException;
}

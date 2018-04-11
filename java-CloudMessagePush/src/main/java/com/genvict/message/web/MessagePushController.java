package com.genvict.message.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.genvict.message.dao.MailService;
import com.genvict.message.framework.service.WsResponse;

@RestController
@RequestMapping("/ws/mail/push")
public class MessagePushController {
	
	private static Logger logger = LoggerFactory.getLogger(MessagePushController.class);
	
	@Autowired
    private MailService MailService;
	
	@Autowired
    private TemplateEngine templateEngine;
	
	@RequestMapping(value= "/simple", method=RequestMethod.GET)
	public WsResponse sendSimpleMail(@RequestParam(name="message") String message)
	{
		logger.info("要发送的人是：cuigl@genvict.com.");
		logger.info("要发送的内容是："+message);
		WsResponse response = new WsResponse();
		try{
			MailService.sendSimpleMail("cuigl@genvict.com","test simple mail", message);
		}catch(Exception e){
			response = new WsResponse(2, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value= "/html", method=RequestMethod.GET)
	public WsResponse testHtmlMail() throws Exception {
		logger.info("要发送的人是：cuigl@genvict.com.");
		WsResponse response = new WsResponse();
	    String content="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";
	    logger.info("要发送的内容是："+content);
	    
	    try{
	    	MailService.sendHtmlMail("cuigl@genvict.com","test simple mail",content);
		}catch(Exception e){
			response = new WsResponse(2, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value= "/attach", method=RequestMethod.GET)
	public WsResponse sendAttachmentsMail() {
		logger.info("要发送的人是：cuigl@genvict.com.");
		WsResponse response = new WsResponse();
	    String filePath="C:\\Users\\cuigl\\Pictures\\help.jpg";
	    logger.info("要发送的内容是："+filePath);
	    
	    try{
	    	MailService.sendAttachmentsMail("cuigl@genvict.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
		}catch(Exception e){
			response = new WsResponse(2, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value= "/resc", method=RequestMethod.GET)
	public WsResponse sendInlineResourceMail() {
		logger.info("要发送的人是：cuigl@genvict.com.");
		WsResponse response = new WsResponse();
	    String rscId = "cuigl001";
	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "C:\\Users\\cuigl\\Pictures\\help.jpg";
	    try{
	    	MailService.sendInlineResourceMail("cuigl@genvict.com", "主题：这是有图片的邮件", content, imgPath, rscId);
		}catch(Exception e){
			response = new WsResponse(2, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value= "/temp", method=RequestMethod.GET)
	public WsResponse sendTemplateMail() {
		logger.info("要发送的人是：cuigl@genvict.com.");
		WsResponse response = new WsResponse();
	    //创建邮件正文
		Context context = new Context();
	    context.setVariable("title", "genvict");
	    context.setVariable("content", "哈哈，我就是模板");
	    String emailContent = templateEngine.process("emailTemplate", context);
	    logger.info("要发送的内容是："+emailContent);
	    
	    try{
	    	MailService.sendHtmlMail("cuigl@genvict.com","主题：这是模板邮件",emailContent);
		}catch(Exception e){
			response = new WsResponse(2, e.getMessage());
		}
		return response;
	}
}

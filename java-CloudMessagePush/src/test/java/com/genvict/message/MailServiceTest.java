package com.genvict.message;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import com.genvict.message.dao.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	@Autowired
    private MailService MailService;
	
	@Autowired
    private TemplateEngine templateEngine;
	
	@Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("cuigl@genvict.com","test simple mail"," hello this is simple mail");
    }
	
	@Test
	public void testHtmlMail() throws Exception {
	    String content="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";
	    MailService.sendHtmlMail("cuigl@genvict.com","test simple mail",content);
	}
	
	@Test
	public void sendAttachmentsMail() throws MessagingException {
	    String filePath="C:\\Users\\cuigl\\Pictures\\help.jpg";
	    MailService.sendAttachmentsMail("cuigl@genvict.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}
	
	@Test
	public void sendInlineResourceMail() throws MessagingException {
	    String rscId = "cuigl001";
	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "C:\\Users\\cuigl\\Pictures\\help.jpg";

	    MailService.sendInlineResourceMail("cuigl@genvict.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}
	
	@Test
	public void sendTemplateMail() throws MessagingException {
	    //创建邮件正文
		Context context = new Context();
	    context.setVariable("title", "genvict");
	    context.setVariable("content", "哈哈，我就是模板");
	    String emailContent = templateEngine.process("emailTemplate", context);

	    MailService.sendHtmlMail("cuigl@genvict.com","主题：这是模板邮件",emailContent);
	}
}

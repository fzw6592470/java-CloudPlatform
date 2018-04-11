package com.genvict.app.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloExController {

	@Value("${cuigl.hello}")
    private String hello;

    @RequestMapping("/helloex")
    public String helloExAction() {
        return this.hello;
    }
}

package com.genvict.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PasswordFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(PasswordFilter.class);
	
	@Override
	public String filterType() {
        return "post"; // 可以在请求被路由之前调用
    }
	@Override
	public int filterOrder() {
        return 1; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }
	
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("isSuccess");
        // 判断上一个过滤器结果为true，否则就不走下面过滤器，直接跳过后面的所有过滤器并返回 上一个过滤器不通过的结果。
//        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }
	
	@Override
	public Object run()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> PasswordFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String password = request.getParameter("password");// 获取请求的参数
        
        if(null != password && password.equals("123456")){
        	ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        }else{
        	ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("password cannot be empty");
            ctx.set("isSuccess", false);
            return null;
        }
        
	}
}

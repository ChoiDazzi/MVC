package kr.letech.mvc.cmmn.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements IController{

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/WEB-INF/view/hello/hello.jsp";
	}

}

package kr.letech.mvc.cmmn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements IController{

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp, Map<String, String[]> map) {
		return "/WEB-INF/view/index.jsp";
	}
}

package kr.letech.mvc.cmmn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	String service(HttpServletRequest req, HttpServletResponse resp, Map<String, String[]> map);
}

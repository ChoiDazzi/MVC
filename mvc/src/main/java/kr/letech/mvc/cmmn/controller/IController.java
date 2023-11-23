package kr.letech.mvc.cmmn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	String service (HttpServletRequest req, HttpServletResponse resp);
}

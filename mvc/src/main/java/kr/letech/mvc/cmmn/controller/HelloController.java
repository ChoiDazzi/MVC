package kr.letech.mvc.cmmn.controller;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements IController{

	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp, Map<String, String[]> map) {//map 필요 없음 
		
		Set<String> keySet=  map.keySet();
        Iterator<String> itr = keySet.iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            String[] values = map.get(key);
            String value = values[0];
            
            req.setAttribute(key, value);
        }

		return "/WEB-INF/view/hello/hello.jsp";
	}

}

package kr.letech.mvc.cmmn.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.letech.mvc.cmmn.controller.IController;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -5408004267647268958L;
	private Map<String, IController> controllerMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		String config = getInitParameter("configController");
		try (InputStream fis = getClass().getClassLoader().getResourceAsStream(config)) {
			Properties properties = new Properties();
			properties.load(fis); //파일 열어줌
			Iterator iter = properties.keySet().iterator();
			while (iter.hasNext()) {
				String url = (String) iter.next();
				String className = properties.getProperty(url);
				try {
					Class<IController> loadClass = (Class<IController>) Class.forName(className);
					IController instance = loadClass.newInstance();
					controllerMap.put(url, instance); 
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI(); //requestURI = /contextPath/example1.do
		Map<String, String[]> map = req.getParameterMap();
		if (requestURI.indexOf(req.getContextPath()) == 0) {
			requestURI = requestURI.substring(req.getContextPath().length()); // example1.do => key
		}
		IController loadController = controllerMap.get(requestURI);
		
		if (loadController == null) {
			//404 처리 
		}
		
		String view = loadController.service(req, resp, map); //jsp 경로 반환 
		if (view != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(view);
			dispatcher.forward(req, resp);
		}
	}
}

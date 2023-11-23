package kr.letech.mvc.cmmn.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -5408004267647268958L;

	@Override
	public void init() throws ServletException {
		String config = getInitParameter("configController");
		//서버의 물리경로
		String configPath = getServletContext().getRealPath(config);

		try (FileInputStream fis = new FileInputStream(configPath)) {
			Properties properties = new Properties();
			properties.load(fis); //파일 열어줌

			Iterator iter = properties.keySet().iterator();
			if (iter.hasNext()) {
				String key = (String) iter.next();
				String value = properties.getProperty(key);
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
		System.out.println("requestURI = " + requestURI);
		if (requestURI.indexOf(req.getContextPath()) == 0) {
			requestURI = requestURI.substring(req.getContextPath().length()); // example1.do
		}

	}
}

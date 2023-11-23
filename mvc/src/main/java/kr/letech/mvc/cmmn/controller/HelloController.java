package kr.letech.mvc.cmmn.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements IController{

    @Override
    public String service(HttpServletRequest req, HttpServletResponse resp) {
        // 1. 명령어와 관련된 비즈니스 로직

        // 2. 뷰페이지에서 사용할 정보 저장

        // 3. jsp 전달
        return null;
    }
}

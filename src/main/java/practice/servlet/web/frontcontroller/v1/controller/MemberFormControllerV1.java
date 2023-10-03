package practice.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.web.frontcontroller.v1.ControllerV1;

public class MemberFormControllerV1 implements ControllerV1 {

    private static final String VIEW_PATH = "/WEB_INF/views/new-form.jsp";

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH);

        dispatcher.forward(request, response); // 다른 서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 다시 호출이 발생
    }

}

package practice.servlet.web.servletmvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    private static final String VIEW_PATH = "/WEB_INF/views/new-form.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH);

        dispatcher.forward(request, response); // 다른 서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 다시 호출이 발생
    }

}
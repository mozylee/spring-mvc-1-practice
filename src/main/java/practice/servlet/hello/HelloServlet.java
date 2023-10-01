package practice.servlet.hello;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("parameterMap = " + parameterMap);
        parameterMap.forEach((k, v) -> System.out.println(String.format("%s : %s", k, v)));

        String userName = request.getParameter("userName");
        System.out.println("userName = " + userName);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter()
                .write(String.format("Hello, %s", userName));
    }

}

package practice.servlet.hello;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames()
               .asIterator()
               .forEachRemaining(System.out::println);

        System.out.println("[전체 파라미터 조회] - end");

        System.out.println("[단일 파라미터 조회]");

        String userName = request.getParameter("user-name");
        String age = request.getParameter("age");
        System.out.println("userName = " + userName);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[중복 이름 파라미터 조회]"); // 중복된 경우, 처음 선언된 value로 기본값 설정
        Arrays.stream(request.getParameterValues("user-name"))
              .forEach(name -> System.out.println("user-name = " + name));
    }

}

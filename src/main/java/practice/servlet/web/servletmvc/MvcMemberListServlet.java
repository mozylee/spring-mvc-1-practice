package practice.servlet.web.servletmvc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private static final String VIEW_PATH = "/WEB_INF/views/members.jsp";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH);
        dispatcher.forward(request, response);
    }

}
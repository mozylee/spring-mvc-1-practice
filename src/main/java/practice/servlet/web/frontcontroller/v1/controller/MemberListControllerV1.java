package practice.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;
import practice.servlet.web.frontcontroller.v1.ControllerV1;

public class MemberListControllerV1 implements ControllerV1 {

    private static final String VIEW_PATH = "/WEB_INF/views/members.jsp";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH);
        dispatcher.forward(request, response);
    }

}

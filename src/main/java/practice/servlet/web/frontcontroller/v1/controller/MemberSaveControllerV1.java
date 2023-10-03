package practice.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;
import practice.servlet.web.frontcontroller.v1.ControllerV1;

public class MemberSaveControllerV1 implements ControllerV1 {

    private static final String VIEW_PATH = "/WEB_INF/views/save-result.jsp";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepository.save(member);

        request.setAttribute("member", member);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH);
        dispatcher.forward(request, response);
    }

}

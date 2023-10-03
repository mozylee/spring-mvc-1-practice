package practice.servlet.web.frontcontroller.v3.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.MyView;
import practice.servlet.web.frontcontroller.v2.ControllerV2;
import practice.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {

    private static final String VIEW_PATH = "members";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        ModelView modelView = new ModelView(VIEW_PATH);

        Map<String, Object> model = modelView.getModel();

        model.put("members", memberRepository.findAll());

        return modelView;
    }

}

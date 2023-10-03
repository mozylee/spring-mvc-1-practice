package practice.servlet.web.frontcontroller.v4.controller;

import java.util.Map;
import practice.servlet.domain.member.MemberRepository;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4 {

    private static final String VIEW_PATH = "members";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("members", memberRepository.findAll());

        return VIEW_PATH;
    }

}

package practice.servlet.web.frontcontroller.v4.controller;

import java.util.Map;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberSaveControllerV4 implements ControllerV4 {

    private static final String VIEW_PATH = "save-result";

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String userName = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(userName, age);
        memberRepository.save(member);

        model.put("member", member);

        return VIEW_PATH;
    }

}

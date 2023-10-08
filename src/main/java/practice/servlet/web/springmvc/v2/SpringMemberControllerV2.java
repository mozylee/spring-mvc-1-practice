package practice.servlet.web.springmvc.v2;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;

@RequestMapping("/springmvc/v2/members")
@Controller
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping
    public ModelAndView getMembers(HttpServletRequest request) {
        List<Member> members = memberRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("members", members);

        return modelAndView;
    }

    @GetMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @PostMapping("/save")
    public ModelAndView saveMember(HttpServletRequest request) {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName, age);
        memberRepository.save(member);

        ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member", member);

        return modelAndView;
    }

}

package practice.servlet.web.springmvc.v3;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import practice.servlet.domain.member.Member;
import practice.servlet.domain.member.MemberRepository;

@RequestMapping("/springmvc/v3/members")
@Controller
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping
    public String getMembers(Model model) {
        model.addAttribute("members", memberRepository.findAll());

        return "members";
    }

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String saveMember(@RequestParam String username, @RequestParam int age, Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }

}

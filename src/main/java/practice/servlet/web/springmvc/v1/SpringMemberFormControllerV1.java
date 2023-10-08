package practice.servlet.web.springmvc.v1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/springmvc/v1/members")
@Controller
public class SpringMemberFormControllerV1 {

    @GetMapping("/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}

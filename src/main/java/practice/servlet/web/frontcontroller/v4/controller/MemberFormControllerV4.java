package practice.servlet.web.frontcontroller.v4.controller;

import java.util.Map;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberFormControllerV4 implements ControllerV4 {

    private static final String VIEW_PATH = "new-form";

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return VIEW_PATH;
    }

}

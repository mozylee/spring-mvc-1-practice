package practice.servlet.web.frontcontroller.v3.controller;

import java.util.Map;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {

    private static final String VIEW_PATH = "new-form";

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView(VIEW_PATH);
    }

}

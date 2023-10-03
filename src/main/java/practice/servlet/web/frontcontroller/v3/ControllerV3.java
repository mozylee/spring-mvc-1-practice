package practice.servlet.web.frontcontroller.v3;

import java.util.Map;
import practice.servlet.web.frontcontroller.ModelView;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}

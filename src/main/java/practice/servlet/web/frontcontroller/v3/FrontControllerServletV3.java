package practice.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practice.servlet.web.frontcontroller.ModelView;
import practice.servlet.web.frontcontroller.MyView;
import practice.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import practice.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import practice.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private final Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (Objects.isNull(controller)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParameterMap(request);

        ModelView view = controller.process(paramMap);

        MyView myView = resolveView(view);
        myView.render(view.getModel(), request, response);
    }

    private static MyView resolveView(ModelView view) {
        return new MyView(String.format("/WEB_INF/views/%s.jsp", view.getViewName()));
    }

    private static Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames()
               .asIterator()
               .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

}

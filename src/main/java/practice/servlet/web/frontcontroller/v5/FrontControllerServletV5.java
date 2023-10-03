package practice.servlet.web.frontcontroller.v5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import practice.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import practice.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import practice.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import practice.servlet.web.frontcontroller.v5.adapter.V3HandlerAdapter;
import practice.servlet.web.frontcontroller.v5.adapter.V4HandlerAdapter;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();

    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();

        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new V3HandlerAdapter());
        handlerAdapters.add(new V4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV5.service");

        Object handler = getHandler(request);
        if (Objects.isNull(handler)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = handlerAdapters.stream()
                                                         .filter(adapter -> adapter.supports(handler))
                                                         .findFirst()
                                                         .orElseThrow(() -> new IllegalArgumentException("Handler Adapter Not Found: " + handler));

        ModelView modelView = handlerAdapter.handle(request, response, handler);

        MyView myView = resolveView(modelView);
        myView.render(modelView.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        return handlerMappingMap.get(requestURI);
    }

    private static MyView resolveView(ModelView view) {
        return new MyView(String.format("/WEB_INF/views/%s.jsp", view.getViewName()));
    }

}

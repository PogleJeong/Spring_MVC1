package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerV4Map = new HashMap<>();

    public FrontControllerServletV4() {
        controllerV4Map.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerV4Map.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerV4Map.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        String requestURI = req.getRequestURI();

        // 호출한 http request 에 따라 어떤 controller 가 작동할지 구분함
        ControllerV4 controllerV4 = controllerV4Map.get(requestURI);

        // 해당 URI 의 매칭되는 controller 가 없을 경우
        if (controllerV4 == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // request 에서 받은 query params 전부 꺼내서 paramMap 에 저장
        // model 생성
        Map<String, String> paramMap = createParamMap(req);
        Map<String, Object> model = new HashMap<>();

        // 데이터저장, model에 데이터 삽입, view name 반환
        String viewName = controllerV4.process(paramMap, model); // 현재까지는 viewName 밖에 없음

        // view resolver 를 통해 물리적위치 반환
        MyView view = viewResolver(viewName);

        // 해당 view 를 render 시 model 을 함께 전송
        view.render(model, req, resp);
    }
    
    // 구체적인 로직은 메서드 화
    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }

    /**
     * view 들의 위치정보가 바뀌어도 여기에서 경로만 한번 수정해주면 해결가능
     * 같은 로직수준을 위해 메서드화
     */
    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}

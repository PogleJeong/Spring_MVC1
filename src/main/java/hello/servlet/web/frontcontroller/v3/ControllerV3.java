package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * V3
 * Controller 에서는 HttpServletRequest, HttpServletResponse 가 필요하지 않을때가 많음
 * 기존의 request 가 하던 역할을 Model 이라는 객체를 만들어 대신하도록 하고자 함
 * 따라서 각 Controller 에서 Model 과 View 반환됨
 * 
 * Controller 가 Servlet 기술을 사용하지 않도록 변경하는 것
 * - 서블릿에 종속되는 문제 해결
 * - 코드작성이 간결해짐
 * - 테스트코드 작성이 수월해짐
 * 
 * FrontController 가 ViewResolver 의 역할을 해줌
 * 뷰의 물리적 위치가 아닌 논리 위치를 사용한다.
 * - 뷰의 폴더위치가 변경되도 FrontController 만 고치면 됨.
 */
public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}

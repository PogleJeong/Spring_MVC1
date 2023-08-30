package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 스프링 MVC 의 핵심인 FrontController 패턴.
 * FrontController 를 제외한 나머지 컨트롤러들은 Servlet 을 사용하지 않아도 된다.
 * 스프링 MVC 의 DispatcherServlet 이 FrontController 패턴으로 구현되어있다.
 */
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

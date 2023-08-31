package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public interface MyHandlerAdapter {
    
    // Adapter 가 해당 컨트롤러(홴들러)를 처리할 수 있는지 판단
    boolean supports(Object handler);
    
    // 실제 컨트롤러를 호출하고 ModelView 를 반환
    // 유연성을 위해 Object model 사용
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}

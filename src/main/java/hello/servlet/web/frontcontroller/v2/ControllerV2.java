package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * v1 에서는 process 메서드의 반환값이 void 였다면
 * v2 부터는 process 메서드의 반환값이 MyView 객체
 * 
 * 중복되는 Dispatcher 부분을 MyView 를 이용해 코드간결화
 * MyView 는 뷰 경로를 가지고 있는 viewPath 멤버변수와, 해당 경로의 뷰를 랜더링하는 render 메서드를 가지고 있음
 */
public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}

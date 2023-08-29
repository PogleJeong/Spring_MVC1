package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        // HttpRequest 에서 query params 가져오기
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        // HttpResponse 작성 (화면에 hello username 나옴)
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8"); // 대부분 utf-8 인코딩 채택
        resp.getWriter().write("hello " + username);
    }
}

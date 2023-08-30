package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.Jar;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Content-Type: application/json
        resp.setContentType("application/json");
//        resp.setCharacterEncoding("utf-8"); Content-Type 으로 Application/json 을 설정하면 자동으로 utf-8 로 설정됨

        HelloData helloData = new HelloData();
        helloData.setUsername("jeong");
        helloData.setAge(25);

        // 객체를 JSON 형식의 string 으로 변환 {"username": "jeong", "age": 25}
        String result = objectMapper.writeValueAsString(helloData);

        resp.getWriter().write(result);
    }
}

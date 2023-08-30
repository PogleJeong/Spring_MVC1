package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Postman으로 테스트하기 : http://localhost:8080/request-body-string
 * POST, content-type: text/plain 으로 message body 를 보낼 경우
 */

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getInputStream 으로 Http request 의 message body 를 읽을 수 있다.
        ServletInputStream inputStream = req.getInputStream(); // messageBody 가져오기
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // stream 을 string 으로 변환(UTF-8)

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("OK");
    }
}

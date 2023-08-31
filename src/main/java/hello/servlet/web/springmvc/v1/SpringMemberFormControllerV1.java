package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 스프링 빈 중에서 클래스 레벨에 @Controller 이나 @RequestMapping 이 있는 경우
 * RequestMappingHandlerMapping 이 매핑정보로 인시함. (해당 클래스를 매핑시킴)
 */
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") // RequestMappingHandlerMapping + RequestMappingHandlerAdapter
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}

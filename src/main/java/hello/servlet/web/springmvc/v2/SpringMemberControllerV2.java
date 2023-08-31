package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 스프링 빈 중에서 클래스 레벨에 @Controller 이나 @RequestMapping 이 있는 경우
 * RequestMappingHandlerMapping 이 매핑정보로 인시함. (해당 클래스를 매핑시킴)
 *  
 * V2
 * V1 에서 여러 흩어져있는 컨트롤러들을 URL 패턴으로 통합
 */
@Controller
@RequestMapping("/springmvc/v2/members") // 공통된 루트
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping
    public ModelAndView printMembers() {

        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }

    @RequestMapping("/new-form") // RequestMappingHandlerMapping + RequestMappingHandlerAdapter
    public ModelAndView join() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }
}

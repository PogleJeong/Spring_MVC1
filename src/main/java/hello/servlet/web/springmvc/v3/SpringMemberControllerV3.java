package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 최근 가장 실무에서 많이 쓰는 실용적인 방식
 * ModelAndView 를 반환하는 것이 아닌 String 을 반환 (view resolver)
 *
 * 애노테이션 기반으로 유연하기 때문에 ModelAndView 뿐 아니라 String 으로 반환하여 사용할 수 있다.
 *
 * frontController 을 직접 구현했을 떄도 V3 의 ModelAndView 를 반환하였지만
 * V4 부터는 viewName 만을 반환한 부분과 일맥상통한다.
 *
 * ModelAndView 에서 Model 은 따로 객체를 통해 사용되고, View 부분은 return 을 통해 forward 된다.
 *
 */
@Controller
@RequestMapping("springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping
    public String printMembers(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }

    @GetMapping("/new-form")
    public String join() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }
}

package spring.feature.sign.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.feature.sign.member.Member;
import spring.feature.sign.service.MemberService;

import java.util.List;

@Controller
@Slf4j
public class MainController {

    private final MemberService memberService;

    //스프링부트 4.3이상부터는 생성자가 하나이면 @Autowired를 붙일 필요X
    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/")
    public String goMain(Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            log.info(session.getAttribute("login").toString());
        }
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "main";
    }
}

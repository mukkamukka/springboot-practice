package spring.feature.sign.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.feature.sign.member.Member;
import spring.feature.sign.service.MemberService;

import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    private final MemberService memberService;

    //스프링부트 4.3이상부터는 생성자가 하나이면 @Autowired를 붙일 필요X
    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/main")
    public String goMain(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("login") != null) {
            log.info("sessionId={}", session.getId());
            log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
            log.info("creationTime={}", new Date(session.getCreationTime()));
            log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
            log.info("isNew={}", session.isNew());
        }
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "main";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            log.info("로그아웃");
        }
        return "redirect:/";
    }
}

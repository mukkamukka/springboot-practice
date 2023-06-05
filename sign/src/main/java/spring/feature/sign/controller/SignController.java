package spring.feature.sign.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.feature.sign.member.Member;
import spring.feature.sign.service.MemberService;

@Controller
@Slf4j
public class SignController {

    private final MemberService memberService;

    public SignController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String goSignUp() {
        return "sign/sign_up";
    }

    @PostMapping("/signup")
    public String addMember(Member member) {
        if (member.getPassword().equals(member.getConfirmPassword())) {
            memberService.createUser(member);
            log.info("회원가입 성공");
            return "redirect:/";
        } else {
            return "sign/sign_up";
        }
    }

    @GetMapping("/")
    public String goSignIn() {
        return "sign/sign_in";
    }

    @PostMapping("/")
    public String signIn(Member member, HttpSession session, Model model) {
        if (session.getAttribute("login") != null) {
            session.invalidate();
        }
        try {
            Member foundMember = memberService.findMember(member.getUserId());
            if (foundMember.getPassword().equals(member.getPassword())) {
                session.setAttribute("login", member.getUserId());
                log.info("로그인 성공");
                return "redirect:/main";
            } else {
                return "redirect:/";
            }
        } catch (Exception e) {
            return "redirect:/";
        }
    }
}

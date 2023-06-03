package spring.feature.sign.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.feature.sign.member.Member;
import spring.feature.sign.member.MemberDTO;
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
            return "redirect:/";
        } else {
            return "sign/sign_up";
        }
    }

    @GetMapping("/signin")
    public String goSignIn() {

        return "sign/sign_in";
    }

    @PostMapping("/signin")
    public String signIn(MemberDTO memberDTO, HttpSession session, Model model) {
        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }
        try {
            MemberDTO foundMember = memberService.findSignInMember(memberDTO.getUserId());
            if (foundMember.getPassword().equals(memberDTO.getPassword())) {
                Member member = memberService.findMember(memberDTO.getUserId());
                session.setAttribute("login", member);
                return "redirect:/";
            } else {
                return "redirect:/signin";
            }
        } catch (Exception e) {
            return "redirect:/signin";
        }
    }
}

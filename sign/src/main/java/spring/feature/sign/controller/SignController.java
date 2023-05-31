package spring.feature.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.feature.sign.dto.Member;
import spring.feature.sign.service.MemberService;

@Controller
public class SignController {

    @Autowired
    MemberService memberService;

    @GetMapping("/signup")
    public String goSignUp() {
        return "sign/sign_up";
    }

    @PostMapping("/signup")
    public String addMember(Member member) {
        memberService.createUser(member);
        return "redirect:/";
    }

    @RequestMapping("/signin")
    public String goSignIn() {
        return "sign/sign_in";
    }
}

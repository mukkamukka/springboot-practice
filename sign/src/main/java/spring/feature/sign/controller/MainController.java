package spring.feature.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.feature.sign.dto.Member;
import spring.feature.sign.mapper.MemberMapper;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MemberMapper memberMapper;

    @RequestMapping("/")
    public String goMain(Model model) {
        List<Member> members = memberMapper.findAll();
        model.addAttribute("members", members);
        return "main";
    }
}

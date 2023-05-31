package spring.feature.sign.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.feature.sign.dto.Member;
import spring.feature.sign.mapper.MemberMapper;

import java.util.List;

@Service
public class MemberService implements MemberMapper {

    @Autowired
    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public void createUser(Member member) {
        memberMapper.createUser(member);
    }
}

package spring.feature.sign.service;

import org.springframework.stereotype.Service;
import spring.feature.sign.member.Member;
import spring.feature.sign.mapper.MemberMapper;
import spring.feature.sign.member.MemberDTO;

import java.util.List;

@Service
public class MemberService implements MemberMapper {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public Member findMember(String id) {
        return memberMapper.findMember(id);
    }

    @Override
    public MemberDTO findSignInMember(String id) {
        return memberMapper.findSignInMember(id);
    }

    @Override
    public void createUser(Member member) {
        memberMapper.createUser(member);
    }
}

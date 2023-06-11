package spring.feature.sign.dao.impl;

import org.springframework.stereotype.Component;
import spring.feature.sign.dao.MemberDao;
import spring.feature.sign.mapper.MemberMapper;
import spring.feature.sign.member.Member;

import java.util.List;

@Component
public class MemberDaoImpl implements MemberDao {
    private final MemberMapper memberMapper;

    public MemberDaoImpl(MemberMapper memberMapper) {
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
    public void createUser(Member member) {
        memberMapper.createUser(member);
    }
}

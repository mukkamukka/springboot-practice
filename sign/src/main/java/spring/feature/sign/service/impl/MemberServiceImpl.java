package spring.feature.sign.service.impl;

import org.springframework.stereotype.Service;
import spring.feature.sign.dao.MemberDao;
import spring.feature.sign.member.Member;
import spring.feature.sign.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public Member findMember(String id) {
        return memberDao.findMember(id);
    }

    @Override
    public void saveMember(Member member) {
        memberDao.createUser(member);
    }
}

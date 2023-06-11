package spring.feature.sign.service;

import org.springframework.stereotype.Service;
import spring.feature.sign.member.Member;
import spring.feature.sign.mapper.MemberMapper;

import java.util.List;

public interface MemberService{

    List<Member> findAll();

    Member findMember(String id);

    void saveMember(Member member);
}

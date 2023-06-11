package spring.feature.sign.dao;

import spring.feature.sign.member.Member;

import java.util.List;

public interface MemberDao {

    List<Member> findAll();

    Member findMember(String id);

    void createUser(Member member);
}

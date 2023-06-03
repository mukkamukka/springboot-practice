package spring.feature.sign.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import spring.feature.sign.member.Member;
import spring.feature.sign.member.MemberDTO;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM member")
    List<Member> findAll();

    @Select("SELECT * FROM MEMBER WHERE userId = #{userId}")
    Member findMember(String id);

    @Select("SELECT * FROM MEMBER WHERE userId = #{userId}")
    MemberDTO findSignInMember(String id);

    @Insert("INSERT INTO member(userId, password, userName) values(#{userId}, #{password}, #{userName})")
    void createUser(Member member);

    /* Mapper.xml 뺀ㄴ~~ */
}

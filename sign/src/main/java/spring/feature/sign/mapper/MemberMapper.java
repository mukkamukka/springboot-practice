package spring.feature.sign.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import spring.feature.sign.dto.Member;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM member")
    List<Member> findAll();

    @Insert("INSERT INTO member(userId, password, userName) values(#{userId}, #{password}, #{userName})")
    void createUser(Member member);
}

package spring.feature.sign.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private String userName;
    private String userId;
    private String password;
    private String confirmPassword;
}

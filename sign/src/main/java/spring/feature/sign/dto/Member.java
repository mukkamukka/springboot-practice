package spring.feature.sign.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String userName;
    private String userId;
    private String password;
    private String confirmPassword;
}

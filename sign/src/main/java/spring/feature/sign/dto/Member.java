package spring.feature.sign.dto;

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

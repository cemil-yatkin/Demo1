package com.SpringProjectOne.Demo1.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Data
@RequiredArgsConstructor
@Setter
@Getter
public class UserDTO {
    private String name;
    private String surname;
    private long userId;
    private String password;
    private String email;

}

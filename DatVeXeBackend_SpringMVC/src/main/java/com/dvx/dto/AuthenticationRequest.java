package com.dvx.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    @NotNull(message = "{user.username.notNull}")
    @Size(min = 5, max = 255, message = "{user.username.size}")
    private String email;
    @NotNull(message = "{user.password.notNull}")
    @Size(min = 3, max = 255, message = "{user.password.size}")
    private String password;
}
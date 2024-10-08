package com.dvx.mapper;


import com.dvx.dto.UserDTO;
import com.dvx.pojo.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("userDTOMapper")
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhonenumber())
                .avatar(user.getAvatar())
                .role(user.getRoleId().getUserRole())
                .build();
    }
}
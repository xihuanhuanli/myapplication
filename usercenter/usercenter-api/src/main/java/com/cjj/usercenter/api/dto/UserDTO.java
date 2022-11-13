package com.cjj.usercenter.api.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;

    private String username;

    private String password;

    private String email;

    private String openId;
}

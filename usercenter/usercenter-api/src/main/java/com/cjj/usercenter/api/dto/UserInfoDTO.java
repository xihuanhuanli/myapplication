package com.cjj.usercenter.api.dto;


import lombok.Data;

@Data
public class UserInfoDTO {
    private int id;

    private int userid;

    private String roles;

    private String name;

    private String avatar;

    private String introduction;
}

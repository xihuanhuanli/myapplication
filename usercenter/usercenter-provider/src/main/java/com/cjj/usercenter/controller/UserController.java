package com.cjj.usercenter.controller;

import com.cjj.common.ResponseData;
import com.cjj.common.util.MD5Util;
import com.cjj.usercenter.api.UserAPI;
import com.cjj.usercenter.api.dto.LoginDTO;
import com.cjj.usercenter.api.dto.UserDTO;

import com.cjj.usercenter.api.dto.UserInfoDTO;
import com.cjj.usercenter.converter.UserConverter;
import com.cjj.usercenter.model.User;
import com.cjj.usercenter.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class UserController implements UserAPI {
    @Autowired
    private UserService userService;

    UserConverter converter = UserConverter.INSTANCE;

    @Value("${salt}")
    private String salt;

    @Override
    public ResponseData<UserDTO> getUserById(@RequestBody UserDTO user) {

        return new ResponseData<>(0, "success", user);
    }

    @Override
    public ResponseData<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User user = converter.userDTOToUser(userDTO);
            userService.save(user);
            return new ResponseData<>(0, "success", null);
        } catch (DuplicateKeyException e) {
            return new ResponseData<>(1, "用户名已经存在", null);
        }

    }

    @Override
    public ResponseData<UserDTO> updateUser(@RequestBody UserDTO user) {

        return new ResponseData<>(0, "success", user);
    }

    @Override
    public ResponseData<UserDTO> deleteUserById(@RequestBody UserDTO user) {
        return new ResponseData<>(0, "success", null);
    }

    @Override
    public ResponseData<LoginDTO> login(@RequestBody UserDTO userDTO) {
        User user = converter.userDTOToUser(userDTO);

        User userFromDB = userService.selectUserByNameAndPassword(user);
        LoginDTO loginDTO = new LoginDTO();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(userFromDB.getId() + "")
                .setSubject(userFromDB.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, salt).
                setExpiration(new Date(System.currentTimeMillis() + 300000));

        if (userFromDB != null) {
            loginDTO.setToken(jwtBuilder.compact());
        }

        return new ResponseData<>(0, "success", loginDTO);
    }
}



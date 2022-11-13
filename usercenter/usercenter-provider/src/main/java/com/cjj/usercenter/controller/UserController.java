package com.cjj.usercenter.controller;

import com.cjj.common.ResponseData;
import com.cjj.common.util.MD5Util;
import com.cjj.usercenter.api.UserAPI;
import com.cjj.usercenter.api.dto.LoginDTO;
import com.cjj.usercenter.api.dto.UserDTO;

import com.cjj.usercenter.converter.UserConverter;
import com.cjj.usercenter.model.User;
import com.cjj.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController implements UserAPI {
    @Autowired
    private UserService userService;

    UserConverter converter = UserConverter.INSTANCE;

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
        if (userFromDB != null) {
            loginDTO.setToken("12312312312312312312312");
        }

        return new ResponseData<>(0, "success1213123123", loginDTO);
    }
}

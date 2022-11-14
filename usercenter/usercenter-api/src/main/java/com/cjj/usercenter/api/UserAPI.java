package com.cjj.usercenter.api;

import com.cjj.common.ResponseData;
import com.cjj.usercenter.api.dto.LoginDTO;
import com.cjj.usercenter.api.dto.UserDTO;
import com.cjj.usercenter.api.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserAPI {

    @RequestMapping(value = "/getUserById",method = RequestMethod.POST)
    ResponseData<UserDTO> getUserById(@RequestBody UserDTO user);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    ResponseData<UserDTO> registerUser(@RequestBody  UserDTO user);

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    ResponseData<UserDTO> updateUser(@RequestBody UserDTO user);


    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    ResponseData<UserDTO> deleteUserById(@RequestBody UserDTO user);

    @RequestMapping(value="/login", method = RequestMethod.POST)
    ResponseData<LoginDTO> login(@RequestBody UserDTO userDTO);

}

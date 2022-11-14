package com.cjj.usercenter.api;

import com.cjj.common.ResponseData;
import com.cjj.usercenter.api.dto.UserDTO;
import com.cjj.usercenter.api.dto.UserInfoDTO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public interface UserInfoAPI {

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    ResponseData<UserInfoDTO> getUserInfo(@RequestBody Map<String,String> map);

    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST)
    ResponseData<UserInfoDTO> addUserInfo(@RequestBody  UserInfoDTO userInfoDTO);

}

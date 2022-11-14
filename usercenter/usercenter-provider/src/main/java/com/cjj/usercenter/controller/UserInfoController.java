package com.cjj.usercenter.controller;


import com.cjj.common.ResponseData;
import com.cjj.usercenter.api.UserInfoAPI;
import com.cjj.usercenter.api.dto.UserDTO;
import com.cjj.usercenter.api.dto.UserInfoDTO;
import com.cjj.usercenter.converter.UserConverter;
import com.cjj.usercenter.converter.UserInfoConverter;
import com.cjj.usercenter.model.User;
import com.cjj.usercenter.model.UserInfo;
import com.cjj.usercenter.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjj
 * @since 2022-11-14
 */
@RestController
@Slf4j
public class UserInfoController implements UserInfoAPI {

    @Autowired
    private UserInfoService userInfoService;

    UserInfoConverter converter = UserInfoConverter.INSTANCE;



    @Override
    public ResponseData<UserInfoDTO> getUserInfoByUserId(UserDTO userDTO) {
        UserInfo userInfo=userInfoService.getUserInfoByUserId(userDTO.getId());
        UserInfoDTO userInfoDTO=converter.UserInfoToUserInfoDTO(userInfo);
        return new ResponseData<>(0, "success", userInfoDTO);
    }

    @Override
    public ResponseData<UserInfoDTO> addUserInfo(UserInfoDTO userInfoDTO) {
        try {
            UserInfo userInfo = converter.UserInfoDTOToUserInfo(userInfoDTO);
            userInfoService.save(userInfo);
            return new ResponseData<>(0, "success", null);
        } catch (DuplicateKeyException e) {
            return new ResponseData<>(1, "用户信息已经存在", null);
        }
    }

}

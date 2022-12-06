package com.cjj.usercenter.controller;


import com.cjj.common.ResponseData;
import com.cjj.usercenter.api.UserInfoAPI;
import com.cjj.usercenter.api.dto.UserInfoDTO;
import com.cjj.usercenter.converter.UserInfoConverter;
import com.cjj.usercenter.model.UserInfo;
import com.cjj.usercenter.service.UserInfoService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @Value("${salt}")
    private String salt;

    UserInfoConverter converter = UserInfoConverter.INSTANCE;



    @Override
    public ResponseData<UserInfoDTO> getUserInfo(@RequestBody Map<String,String> map) {
        String token = map.get("token");
        Claims claims = Jwts.parser().setSigningKey(salt).parseClaimsJws(token).getBody();
        String userid = claims.getId();
        System.out.println("123123123");
        int a = 0;
        UserInfo userInfo=userInfoService.getUserInfoByUserId(Integer.valueOf(userid));
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

    @Override
    public ResponseData logout() {
        return new ResponseData<>(0, "success", null);
    }

}

package com.cjj.usercenter.converter;

import com.cjj.usercenter.api.dto.UserInfoDTO;
import com.cjj.usercenter.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoConverter {

    UserInfoConverter INSTANCE = Mappers.getMapper( UserInfoConverter.class );

    UserInfo UserInfoDTOToUserInfo(UserInfoDTO userInfoDTO);
    UserInfoDTO UserInfoToUserInfoDTO(UserInfo userInfo);
}

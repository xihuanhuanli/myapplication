package com.cjj.usercenter.converter;

import com.cjj.usercenter.api.dto.UserDTO;
import com.cjj.usercenter.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper( UserConverter.class );

    User userDTOToUser(UserDTO user);

    UserDTO userToUserDTO(User user);

}

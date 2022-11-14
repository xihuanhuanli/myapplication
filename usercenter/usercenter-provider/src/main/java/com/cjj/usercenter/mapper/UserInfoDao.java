package com.cjj.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cjj.usercenter.model.UserInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjj
 * @since 2022-11-14
 */
public interface UserInfoDao extends BaseMapper<UserInfo> {
    UserInfo getUserInfoByUserId(int userid);
}

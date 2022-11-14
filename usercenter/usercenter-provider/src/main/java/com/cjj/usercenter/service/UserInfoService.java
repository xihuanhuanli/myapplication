package com.cjj.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.cjj.usercenter.model.UserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjj
 * @since 2022-11-14
 */
public interface UserInfoService extends IService<UserInfo> {
    UserInfo getUserInfoByUserId (int userid);
}

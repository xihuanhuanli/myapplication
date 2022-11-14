package com.cjj.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjj.usercenter.mapper.UserInfoDao;
import com.cjj.usercenter.model.UserInfo;
import com.cjj.usercenter.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjj
 * @since 2022-11-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public UserInfo getUserInfoByUserId(int userid) {
        return  userInfoDao.getUserInfoByUserId(userid);
    }
}

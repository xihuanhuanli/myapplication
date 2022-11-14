package com.cjj.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjj.common.util.MD5Util;
import com.cjj.usercenter.api.dto.UserInfoDTO;
import com.cjj.usercenter.mapper.UserDao;
import com.cjj.usercenter.model.User;
import com.cjj.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjj
 * @since 2022-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User entity) {
        entity.setPassword(MD5Util.MD5Upper(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public User selectUserByNameAndPassword(User user) {
        user.setPassword(MD5Util.MD5Upper(user.getPassword()));
        return userDao.selectUserByNameAndPassword(user);
    }


}

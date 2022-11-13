package com.cjj.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjj.usercenter.model.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjj
 * @since 2022-11-13
 */
public interface UserService extends IService<User> {
    User selectUserByNameAndPassword(User user);
}

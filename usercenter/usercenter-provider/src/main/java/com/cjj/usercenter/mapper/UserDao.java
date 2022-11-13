package com.cjj.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjj.usercenter.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjj
 * @since 2022-11-13
 */
public interface UserDao extends BaseMapper<User> {
    User selectUserByNameAndPassword(User user);
}

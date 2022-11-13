package com.cjj.order.outer;

import com.cjj.usercenter.api.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="usercenter")
public interface UserService extends UserAPI {
}

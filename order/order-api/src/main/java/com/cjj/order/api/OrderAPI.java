package com.cjj.order.api;

import com.cjj.common.ResponseData;
import com.cjj.order.api.dto.OrderDTO;
import com.cjj.usercenter.api.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface OrderAPI {

    @RequestMapping(path = "/getOrderByUserId",method = RequestMethod.POST)
    ResponseData<OrderDTO> getOrderByUserId(UserDTO userid);
}

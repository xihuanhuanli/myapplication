package com.cjj.order.api.dto;

import com.cjj.usercenter.api.dto.UserDTO;
import lombok.Data;

@Data
public class OrderDTO {

    private int id;
    private String orderNo;
    private UserDTO userDTO;
    private int productId;
}

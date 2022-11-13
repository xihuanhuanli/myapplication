package com.cjj.order.controller;

import com.cjj.common.ResponseData;
import com.cjj.order.api.OrderAPI;
import com.cjj.order.api.dto.OrderDTO;
import com.cjj.order.outer.UserService;
import com.cjj.usercenter.api.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class OrderController implements OrderAPI {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @Override
    public ResponseData<OrderDTO> getOrderByUserId(@RequestBody UserDTO userid) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNo("Order1234567");
        orderDTO.setProductId(777);
        orderDTO.setId(555);

        ResponseData<UserDTO> responseData = userService.getUserById(userid);
        orderDTO.setUserDTO(responseData.getData());

        //通过usercenter 提供的接口查询userDTO

//        try {
//            //获取usercenter在nacos上注册的所有ip
//            List<ServiceInstance> instances = discoveryClient.getInstances("usercenter");
//            int index = new Random().nextInt(instances.size());
//            //随机取一个instance
//            ServiceInstance instance = instances.get(index);
//            String host = instance.getHost();
//            int port = instance.getPort();
//            String schema = instance.getScheme();
//
//            //通过httpClient发起http请求
//            //新建一个OkHttpClient对象
//            OkHttpClient client = new OkHttpClient();
//
//            //构建requestBody
//            MediaType mediaType = MediaType.get("application/json; charset=utf-8");
//            ObjectMapper mapper = new ObjectMapper();
//            String userDtoString = mapper.writeValueAsString(userid);
//            log.info("requestBodyString ========" + userDtoString);
//            okhttp3.RequestBody body = okhttp3.RequestBody.create(userDtoString, mediaType);
//            String path = "/getUserById";
//            //构建request对象
//            Request request = new Request.Builder()
//                    .url("http://" + host + ":" + port + path)
//                    .post(body).build();
//
//            Response response = client.newCall(request).execute();
//            String responseString = response.body().string();
//            log.info("responseString ========" + responseString);
//
//            JavaType javaType = mapper.getTypeFactory().constructParametricType(ResponseData.class, UserDTO.class);
//            ResponseData<UserDTO> responseObj = mapper.readValue(responseString, javaType);
//            UserDTO userDTOFromHttp = responseObj.getData();
//
//            orderDTO.setUserDTO(userDTOFromHttp);
//
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            //log.error("发生错误", e.);
//            return new ResponseData<>(1, "error", null);
//        }


        return new ResponseData<>(0, "success", orderDTO);
    }

}

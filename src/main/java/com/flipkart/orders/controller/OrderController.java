package com.flipkart.orders.controller;

import com.flipkart.orders.config.UserFeignClient;
import com.flipkart.orders.dto.ApiResponse;
import com.flipkart.orders.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    UserFeignClient userFeignClient;
    @GetMapping("/{id}")
    public Long getOrder(@PathVariable Long id) {
        LOGGER.info("@OrderController.getOrder:req:"+id);
        ApiResponse<UserDto> userDto = userFeignClient.getUserById(id);
        LOGGER.info("@OrderController.getOrder:response:"+id);
        return  userDto.getData().getUserId();
    }
}

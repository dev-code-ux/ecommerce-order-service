package com.flipkart.orders.config;

import com.flipkart.orders.dto.ApiResponse;
import com.flipkart.orders.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    ApiResponse<UserDto> getUserById(@PathVariable Long id);
}

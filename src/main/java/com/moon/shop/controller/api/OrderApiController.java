package com.moon.shop.controller.api;

import com.moon.shop.config.auth.PrincipalDetail;
import com.moon.shop.domain.Item;
import com.moon.shop.domain.Order;
import com.moon.shop.domain.OrderItem;
import com.moon.shop.dto.ResponseDto;
import com.moon.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    //주문 생성
    @PostMapping("/api/user/order")
    public ResponseDto<Integer> save(@RequestBody Item item, OrderItem orderItem, @AuthenticationPrincipal PrincipalDetail principal){
        orderService.createOrder(principal.getUsername(), item.getId(), orderItem.getCount());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //주문 취소
    @DeleteMapping("/api/user/order/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        orderService.deleteOrder(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}

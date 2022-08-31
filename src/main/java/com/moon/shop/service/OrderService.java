package com.moon.shop.service;

import com.moon.shop.domain.*;
import com.moon.shop.repository.ItemRepository;
import com.moon.shop.repository.MemberRepository;
import com.moon.shop.repository.OrderItemRepository;
import com.moon.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문 생성
    @Transactional
    public void createOrder(String memberName, int itemId, int count){
        Member member = new Member();
        member = memberRepository.findByMemberUsername(memberName);

        Item item = itemRepository.findById(itemId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 상품은 유효하지 않습니다.");
                        });

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getItemPrice(),count);
        Order order = Order.createOrder(member, orderItem);
        orderRepository.save(order);
    }

    //주문 취소
    @Transactional
    public void deleteOrder(int id){
        Order order = orderRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 주문은 존재하지 않습니다.");
        });
        order.cancel();
    }



}

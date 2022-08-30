package com.moon.shop.repository;

import com.moon.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Item, Integer> {
}

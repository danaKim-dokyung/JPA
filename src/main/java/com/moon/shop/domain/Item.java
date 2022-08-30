package com.moon.shop.domain;

import com.moon.shop.exception.StockQuantityException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int Id;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_price")
    private int itemPrice;

    @Column(name="item_origin")
    private String itemOrigin;

    @Column(name="item_category")
    private String itemCategory;

    @Column(name="item_stock")
    private int itemStock;

    //Stock ++
    public void addStock(int quantity){
        this.itemStock += quantity;
    }

    //Stock --
    public void removeStock(int quantity){
        int restStock = this.itemStock - quantity;
        if(restStock < 0){
            throw new StockQuantityException("재고가 부족합니다.");
        }
        this.itemStock = restStock;
    }

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();




}

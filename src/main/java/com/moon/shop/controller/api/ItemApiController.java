package com.moon.shop.controller.api;

import com.moon.shop.domain.Item;
import com.moon.shop.dto.ResponseDto;
import com.moon.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

    private final ItemService itemservice;

    //상품 등록
    @PostMapping("/api/admin/item")
    public ResponseDto<Integer> save(@RequestBody Item item){
        itemservice.saveItem(item);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    //상품 삭제
    @DeleteMapping("/api/admin/item/{id}")
    public ResponseDto<Integer> delete(@PathVariable int id){
        itemservice.deleteItem(id);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    //상품 수정
    @PutMapping("/api/admin/item/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Item item){
        itemservice.updateItem(id, item);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    //전체 상품 조회
    @GetMapping("/api/item/list")
    public List<Item> list(){
        List<Item> itemList = itemservice.itemList();
        return itemList;
    }

    //상품 상세 조회
    @GetMapping("/api/item/{id}")
    public Item findByItemId(@PathVariable int id){
        Item itemDetail = itemservice.itemDetail(id);
        return itemDetail;
    }

}

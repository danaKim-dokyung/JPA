package com.moon.shop.service;

import com.moon.shop.domain.Item;
import com.moon.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    //상품 등록
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    //상품 삭제
    @Transactional
    public void deleteItem(int itemId){
        itemRepository.deleteById(itemId);
    }

    //상품 수정
    @Transactional
    public void updateItem(int itemId, Item requestItem){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 상품을 찾을 수 없습니다.");
                });
        item.setItemName(requestItem.getItemName());
        item.setItemCategory(requestItem.getItemCategory());
        item.setItemPrice(requestItem.getItemPrice());
        item.setItemOrigin(requestItem.getItemOrigin());
    }

    //전체 상품 조회
    @Transactional(readOnly = true)
    public List<Item> itemList(){
        return itemRepository.findAll();
    }

    //상품 상세 조회
    @Transactional(readOnly = true)
    public Item itemDetail(int itemId){
        return itemRepository.findById(itemId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 상품을 찾을 수 없습니다.");
                });
    }
}

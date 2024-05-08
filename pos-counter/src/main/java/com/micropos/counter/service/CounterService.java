package com.micropos.counter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CounterService {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private CartMapper cartMapper;


    public double getTotal(CartDto cart) {
        double total = 0;
        for (CartItemDto item : cart.getItems()) {
            total += item.getAmount() * item.getProduct().getPrice();
        }
        return total;
    }

    public double checkout(CartDto cartDto) {
        String url1 = "http://pos-carts/carts/{cartId}";
        restTemplate.delete(url1, cartDto.getId());

//        Cart cart = cartMapper.toCart(cartDto);
        String url2 = "http://pos-products/products/{productId}";
        cartDto.getItems().forEach(cartItem -> {
            ProductDto productDto = cartItem.getProduct();
            int quantity = productDto.getQuantity();
            int newQuantity = quantity - cartItem.getAmount();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode quantityJsonObject = objectMapper.createObjectNode();
            quantityJsonObject.put("quantity", newQuantity);
            restTemplate.patchForObject(url2, quantityJsonObject, Object.class);
        });
        return getTotal(cartDto);
    }
}

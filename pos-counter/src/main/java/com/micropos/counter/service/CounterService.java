package com.micropos.counter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    CartDto cartDto = null;
    public double checkout(Integer cartId) {
        String url1 = "http://pos-carts/carts/{cartId}";


//        Cart cart = cartMapper.toCart(cartDto);
        String url2 = "http://pos-products/products/{productId}";
        if (cartDto == null) {
            cartDto = restTemplate.getForObject(url1, CartDto.class, cartId);
        }
        cartDto.getItems().forEach(cartItem -> {
            ProductDto productDto = cartItem.getProduct();
            int quantity = productDto.getProductQuantity();
            int newQuantity = quantity - cartItem.getAmount();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode quantityJsonObject = objectMapper.createObjectNode();
            quantityJsonObject.put("quantity", newQuantity);
            Map<String, Object> uriVariables = new HashMap<>();
            uriVariables.put("productId", cartItem.getProduct().getId());
//            restTemplate.patchForObject(url2, quantityJsonObject, Object.class, uriVariables);
        });
//        restTemplate.delete(url1, cartId);
        double ret = getTotal(cartDto);
        for(int i = 0; i < 10000; i++) {
            ret += getTotal(cartDto);
        }
        ret /= 1000000;
        return ret;
    }
//    public double checkout(Integer cartId) {
//        String url1 = "http://pos-carts/carts/{cartId}";
//
//
////        Cart cart = cartMapper.toCart(cartDto);
//        String url2 = "http://pos-products/products/{productId}";
//        CartDto cartDto = restTemplate.getForObject(url1, CartDto.class, cartId);
//        cartDto.getItems().forEach(cartItem -> {
//            ProductDto productDto = cartItem.getProduct();
//            int quantity = productDto.getProductQuantity();
//            int newQuantity = quantity - cartItem.getAmount();
//            ObjectMapper objectMapper = new ObjectMapper();
//            ObjectNode quantityJsonObject = objectMapper.createObjectNode();
//            quantityJsonObject.put("quantity", newQuantity);
//            Map<String, Object> uriVariables = new HashMap<>();
//            uriVariables.put("productId", cartItem.getProduct().getId());
//            restTemplate.patchForObject(url2, quantityJsonObject, Object.class, uriVariables);
//        });
//        restTemplate.delete(url1, cartId);
//        return getTotal(cartDto);
//    }
}

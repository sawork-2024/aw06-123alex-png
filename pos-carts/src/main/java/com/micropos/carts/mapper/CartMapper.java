package com.micropos.carts.mapper;

import java.util.*;

import com.micropos.carts.*;
import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Bean;

@Mapper
public interface CartMapper {

    Collection<Cart> toCarts(Collection<CartDto> cartDtos);
    Collection<CartDto> toCartDtos(Collection<Cart> carts);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "quantity", target = "amount"),
            @Mapping(source = "cart.id", target = "cartId"),  // 修改此处，只映射 cart 的 id
            @Mapping(target = "product.id", source = "productId"),
            @Mapping(target = "product.name", source = "productName"),
            @Mapping(target = "product.price", source = "price"),
            @Mapping(target = "product.productQuantity", source = "productQuantity")
    })
    CartItemDto toCartItemDto(CartItem cartItem);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "cartId", target = "cart.id"),  // 此处接收 cartId 并将其映射到 cart
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "product.name", target = "productName"),
            @Mapping(source = "product.price", target = "price"),
            @Mapping(source = "product.productQuantity", target = "productQuantity")
    })
    CartItem toCartItem(CartItemDto cartItemDto);

    @Mapping(source = "cartItems", target = "items")
    @Mapping(source = "id", target = "id")
    CartDto toCartDto(Cart cart);

    @Mapping(source = "items", target = "cartItems")
    @Mapping(source = "id", target = "id")
    Cart toCart(CartDto cartDto);
}

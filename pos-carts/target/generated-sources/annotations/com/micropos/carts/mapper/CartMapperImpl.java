package com.micropos.carts.mapper;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public Collection<Cart> toCarts(Collection<CartDto> cartDtos) {
        if ( cartDtos == null ) {
            return null;
        }

        Collection<Cart> collection = new ArrayList<Cart>( cartDtos.size() );
        for ( CartDto cartDto : cartDtos ) {
            collection.add( toCart( cartDto ) );
        }

        return collection;
    }

    @Override
    public Collection<CartDto> toCartDtos(Collection<Cart> carts) {
        if ( carts == null ) {
            return null;
        }

        Collection<CartDto> collection = new ArrayList<CartDto>( carts.size() );
        for ( Cart cart : carts ) {
            collection.add( toCartDto( cart ) );
        }

        return collection;
    }

    @Override
    public CartItem toCartItem(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItem cartItem = new CartItem();

        cartItem.id( cartItemDto.getId() );

        return cartItem;
    }

    @Override
    public CartItemDto toCartItemDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        return cartItemDto;
    }

    @Override
    public Cart toCart(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        return cart;
    }

    @Override
    public CartDto toCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        return cartDto;
    }
}

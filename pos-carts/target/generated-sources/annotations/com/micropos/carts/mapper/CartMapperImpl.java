package com.micropos.carts.mapper;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    public CartItemDto toCartItemDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setProduct( cartItemToProductDto( cartItem ) );
        cartItemDto.setId( cartItem.getId() );
        cartItemDto.setAmount( cartItem.getQuantity() );
        cartItemDto.setCartId( cartItemCartId( cartItem ) );

        return cartItemDto;
    }

    @Override
    public CartItem toCartItem(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItem cartItem = new CartItem();

        cartItem.setCart( cartItemDtoToCart( cartItemDto ) );
        cartItem.setId( cartItemDto.getId() );
        cartItem.setQuantity( cartItemDto.getAmount() );
        cartItem.setProductId( cartItemDtoProductId( cartItemDto ) );
        cartItem.setProductName( cartItemDtoProductName( cartItemDto ) );
        Double price = cartItemDtoProductPrice( cartItemDto );
        if ( price != null ) {
            cartItem.setPrice( price );
        }
        cartItem.setProductQuantity( cartItemDtoProductProductQuantity( cartItemDto ) );

        return cartItem;
    }

    @Override
    public CartDto toCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setItems( cartItemListToCartItemDtoList( cart.getCartItems() ) );
        cartDto.setId( cart.getId() );

        return cartDto;
    }

    @Override
    public Cart toCart(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartItems( cartItemDtoListToCartItemList( cartDto.getItems() ) );
        cart.setId( cartDto.getId() );

        return cart;
    }

    protected ProductDto cartItemToProductDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( cartItem.getProductId() );
        productDto.setName( cartItem.getProductName() );
        productDto.setPrice( cartItem.getPrice() );
        productDto.setProductQuantity( cartItem.getProductQuantity() );

        return productDto;
    }

    private Integer cartItemCartId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Cart cart = cartItem.getCart();
        if ( cart == null ) {
            return null;
        }
        Integer id = cart.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Cart cartItemDtoToCart(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( cartItemDto.getCartId() );

        return cart;
    }

    private Integer cartItemDtoProductId(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }
        ProductDto product = cartItemDto.getProduct();
        if ( product == null ) {
            return null;
        }
        Integer id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String cartItemDtoProductName(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }
        ProductDto product = cartItemDto.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Double cartItemDtoProductPrice(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }
        ProductDto product = cartItemDto.getProduct();
        if ( product == null ) {
            return null;
        }
        Double price = product.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private Integer cartItemDtoProductProductQuantity(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }
        ProductDto product = cartItemDto.getProduct();
        if ( product == null ) {
            return null;
        }
        Integer productQuantity = product.getProductQuantity();
        if ( productQuantity == null ) {
            return null;
        }
        return productQuantity;
    }

    protected List<CartItemDto> cartItemListToCartItemDtoList(List<CartItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItemDto> list1 = new ArrayList<CartItemDto>( list.size() );
        for ( CartItem cartItem : list ) {
            list1.add( toCartItemDto( cartItem ) );
        }

        return list1;
    }

    protected List<CartItem> cartItemDtoListToCartItemList(List<CartItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItem> list1 = new ArrayList<CartItem>( list.size() );
        for ( CartItemDto cartItemDto : list ) {
            list1.add( toCartItem( cartItemDto ) );
        }

        return list1;
    }
}

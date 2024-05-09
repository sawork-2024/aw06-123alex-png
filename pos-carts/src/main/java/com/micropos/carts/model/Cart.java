package com.micropos.carts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "carts")
public class Cart implements Serializable {

    private static final long serialVersionUID = -5555559482394141750L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name="cartItems",
//            joinColumns = @JoinColumn(name="cart_id"))
    private List<CartItem> cartItems = new ArrayList<>();

    // Default constructor
    public Cart() {
        this.id = -1;
    }

    // Constructor with parameters
    public Cart(Integer id, List<CartItem> cartItems) {
        this.id = id;
        if(cartItems != null && !cartItems.isEmpty()) {
            this.cartItems.addAll(cartItems);
        }
    }

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for cartItems
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Method to add an item to the cart
    public boolean addItem(CartItem item) {
        return cartItems.add(item);
    }

    // Method to remove an item from the cart
    public boolean removeItem(CartItem item) {
        return cartItems.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cart{");
        builder.append("id=").append(id);
        builder.append(", cartItems=[");
        for (CartItem item : cartItems) {
            builder.append(item.toString()).append(", ");
        }
        if (!cartItems.isEmpty()) {
            builder.setLength(builder.length() - 2);  // 移除最后的逗号和空格
        }
        builder.append("]}");
        return builder.toString();
    }

}

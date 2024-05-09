package com.micropos.carts.model;

import io.swagger.models.auth.In;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CartItems")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 3584564208528154187L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cart_id")  // 直接使用 cart_id 作为外键
    private Cart cart;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "price")
    private double price;

    // Default constructor
    public CartItem() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer quantity) {
        this.productQuantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                "cart=" + cart +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}

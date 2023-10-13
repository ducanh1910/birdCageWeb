package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class ShoppingCart {
    @Id
    @Column(name = "shopping_cart_id", nullable = false)
    private long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "totalItems", nullable = false)
    private int totalItems;

    @NotNull
    @Column(name = "totalPrice", nullable = false, precision = 10, scale = 2)
    private double totalPrice;

    @NotNull
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "shoppingCart")
    private Set<CartItem> cartItems;

    @OneToOne(mappedBy = "shoppingCart")
    private Product product;

    public ShoppingCart() {
        this.cartItems = new HashSet<>();
        this.totalItems = 0;
        this.totalPrice = 0.0;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", customer=" + customer.getUserName() +
                ", totalPrice=" + totalPrice +
                ", totalItems=" + totalItems +
                ", cartItems=" + cartItems.size() +
                '}';
    }

}
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartItem {
    @Id
    @Column(name = "cart_item_id", nullable = false)
    private long id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "unitPrice", nullable = false, precision = 10, scale = 2)
    private double unitPrice;

    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.EAGER, cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @jakarta.persistence.JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;


}
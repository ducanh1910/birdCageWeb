package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "currentQuantity", nullable = false)
    private Integer currentQuantity;

    @Size(max = 1000)
    @NotNull
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Size(max = 255)
    @NotNull
    @Column(name = "image", nullable = false)
    private String image;

    @NotNull
    @Column(name = "costPrice", nullable = false, precision = 10, scale = 2)
    private double costPrice;

    @NotNull
    @Column(name = "salePrice", nullable = false, precision = 10, scale = 2)
    private double salePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "is_activated", columnDefinition = "tinyint not null")
    private boolean isActivated;

    @Column(name = "is_deleted", columnDefinition = "tinyint not null")
    private boolean isDeleted;

    @OneToOne(mappedBy = "product")
    private ShoppingCart shoppingCart;

}
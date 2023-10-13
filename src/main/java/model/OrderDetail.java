package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class OrderDetail {
    @Id
    @Column(name = "order_detail_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "totalPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @NotNull
    @Column(name = "unitPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @jakarta.persistence.ManyToOne (fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "order_table_id", referencedColumnName = "order_table_id")
    private OrderTable orderTable;

    @jakarta.persistence.OneToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

}
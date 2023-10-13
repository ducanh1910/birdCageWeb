package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class OrderTable {
    @Id
    @Column(name = "order_table_id", nullable = false)
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Address_id", nullable = false)
    private Address address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_id", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @NotNull
    @Column(name = "deliveryDate", nullable = false)
    private Date deliveryDate;

    @Column(name = "isAccept", columnDefinition = "tinyint not null")
    private boolean isAccept;

    @NotNull
    @Column(name = "orderStatus", nullable = false)
    private String orderStatus;

    @NotNull
    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod ;

    @NotNull
    @Column(name = "totalPrice", nullable = false, precision = 10, scale = 2)
    private double totalPrice;

    @NotNull
    @Column(name = "tax", nullable = false, precision = 10, scale = 2)
    private double tax;

    @NotNull
    @Column(name = "quantity", nullable = false, precision = 10, scale = 2)
    private int quantity;

    @jakarta.persistence.OneToMany(cascade = jakarta.persistence.CascadeType.ALL, mappedBy = "orderTable")
    private List<OrderDetail> orderDetailList;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", totalPrice=" + totalPrice +
                ", tax='" + tax + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", customer=" + customer.getUserName() +
                ", orderDetailList=" + orderDetailList.size() +
                '}';
    }

}
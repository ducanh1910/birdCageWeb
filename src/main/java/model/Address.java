package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "streetName", nullable = false)
    private String streetName;

    @Size(max = 255)
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @jakarta.persistence.JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

}
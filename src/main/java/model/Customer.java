package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    private long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "userName", nullable = false)
    private String userName;

    @Size(max = 255)
    @NotNull
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Size(max = 255)
    @NotNull
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @jakarta.persistence.ManyToMany(fetch = jakarta.persistence.FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_role", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

    @jakarta.persistence.OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;
    @jakarta.persistence.OneToMany(mappedBy = "customer")
    private List<OrderTable> orderTables;
    @jakarta.persistence.OneToMany(mappedBy = "customer")
    private List<Address> address;

    public Customer() {
        this.shoppingCart = new ShoppingCart();
        this.orderTables = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", roles=" + roles +
                ", cart=" + shoppingCart.getId() +
                ", orders=" + orderTables.size() +
                '}';
    }
}
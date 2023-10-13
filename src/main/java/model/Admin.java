package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    @Column(name = "admin_id", nullable = false)
    private Integer id;

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
    @Column(name = "Image", nullable = false)
    private String image;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @javax.persistence.ManyToMany(fetch = javax.persistence.FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinTable(name = "admins_roles", joinColumns = @javax.persistence.JoinColumn(name = "admin_id", referencedColumnName = "admin_id"),
            inverseJoinColumns = @javax.persistence.JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

}
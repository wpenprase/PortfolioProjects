package com.d288.vacationbooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
@Table (name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "customer_id", nullable = false)
    private long id;

    @Column (name = "address", nullable = false)
    private String address;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "customer_first_name", nullable = false)
    private String firstName;

    @Column (name = "customer_last_name", nullable = false)
    private String lastName;

    @Column (name = "phone", nullable = false)
    private String phone;

    @Column (name = "postal_code", nullable = false)
    private String postal_code;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id"/*, nullable = false*/)
    private Division division_id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cart> carts = new HashSet<>();

    public void addCart(Cart cart){
        if (cart != null){
            if (carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }

    public Customer(
            String firstName,
            String lastName,
            String address,
            String postal_code,
            String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
    }
}

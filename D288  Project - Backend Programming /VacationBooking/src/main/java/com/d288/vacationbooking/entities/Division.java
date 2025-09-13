package com.d288.vacationbooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "division_id")
    private long id;

    @Column(name = "division", nullable = false)
    private String division_name; //division_id???????

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "division_id")
    private Set<Customer> customers = new HashSet<>();

/*    @Column (name = "country_id")
    private long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getCountry_id());
        this.country = country;
    }*/

    @Column (name = "country_id")
    private long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

}

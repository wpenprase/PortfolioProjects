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
@Table (name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column (name = "country_id")
    private long id;/* changed from country_id to id. ???????? */

    @Column(name = "country")
    private String country_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <Division> divisions = new HashSet<>();

    /*public long getCountry_id() {
        return 0;
    }*/
}

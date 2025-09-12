package com.d288.vacationbooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "vacation_id")
    private long id;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "description")
    private String description;

    @Column (name = "image_url")
    private String image_URL;

    @Column (name = "travel_fare_price")
    private Double travel_price;

    @Column (name = "vacation_title")
    private String vacation_title;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany (mappedBy = "vacation", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Set<Excursion> excursions;

}

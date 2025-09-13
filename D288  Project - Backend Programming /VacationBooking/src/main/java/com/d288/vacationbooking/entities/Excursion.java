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
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "excursion_id")
    private long id;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "excursion_price")
    private double excursion_price;

    @Column (name = "excursion_title")
    private String excursion_title;

    @Column (name = "image_url")
    private String image_URL;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column (name = "vacation_id")/*?????????*/
    private long vacation_id;

    //forgot to name my column to vacation_id :(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", insertable = false, updatable = false)
    private Vacation vacation;

    @ManyToMany (mappedBy = "excursions")
    private Set<CartItem> cartitems = new HashSet<>();

}

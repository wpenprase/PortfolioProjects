package com.d288.vacationbooking.services;

import com.d288.vacationbooking.entities.Cart;
import com.d288.vacationbooking.entities.CartItem;
import com.d288.vacationbooking.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}

package com.d288.vacationbooking.services;

import com.d288.vacationbooking.dao.CartRepository;
import com.d288.vacationbooking.dao.CustomerRepository;
import com.d288.vacationbooking.entities.Cart;
import com.d288.vacationbooking.entities.CartItem;
import com.d288.vacationbooking.entities.Customer;
import com.d288.vacationbooking.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service

public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

            //Retrieve the cart info from the dao
            Cart cart = purchase.getCart();

            //generate tracking number
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            //populate the cart with cartitems
            Set<CartItem> cartItems = purchase.getCartItems();

        if (purchase.getCartItems() == null || purchase.getCartItems().isEmpty() ) {
            return new PurchaseResponse("Error: Your cart is empty") ;
        }
            cartItems.forEach(cart::addCartItem);
            cart.setStatus(StatusType.ordered);
            cartRepository.save(cart);

            return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //Generate a random UUID (uuid version-4)
        //For details see: https;//en.wikipedia.org

        return UUID.randomUUID().toString();
    }


}

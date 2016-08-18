package com.bikestore.service;

import com.bikestore.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}

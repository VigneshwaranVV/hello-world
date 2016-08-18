package com.bikestore.dao;


import com.bikestore.model.Cart;
import com.bikestore.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}

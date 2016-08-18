package com.bikestore.service;


import com.bikestore.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}

package com.goods.courierapp.service;

import com.goods.courierapp.models.Customer;

public interface CustomerService {

    Customer save ( Customer theCustomer);

    void deleteById (int theId);

    Customer findById(int customerId);
}

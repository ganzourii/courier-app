package com.goods.courierapp.service;

import com.goods.courierapp.dao.CustomerRepository;
import com.goods.courierapp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }

    @Override
    public Customer save(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    public Customer findById(int customerId) {

        Optional<Customer> result = customerRepository.findById(customerId);
        Customer theCustomer = null;
        if(result.isPresent())
        {
            theCustomer = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find customer id: " + customerId );
        }
        return theCustomer;
    }

    @Override
    public Customer findByUsername(String username) {

        Optional<Customer> result = customerRepository.findByUsername(username);
        Customer theCustomer = null;
        if(result.isPresent())
        {
            theCustomer = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find customer username: " + username );
        }
        return theCustomer;
    }

}

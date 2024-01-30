package com.goods.courierapp.rest;

import com.goods.courierapp.models.Customer;
import com.goods.courierapp.models.Pilot;
import com.goods.courierapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService theCustomerService) {
        this.customerService = theCustomerService;
    }

    @GetMapping("/test")
    public String  sayHello(){
        return "Hello, World! FROM CUSTOMERS CONTROLLER!!";
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer (@PathVariable int customerId)
    {
        Customer theCustomer = customerService.findById(customerId);

        if( theCustomer == null)
            throw new RuntimeException("Customer with id: "+customerId+" not found!");

        return theCustomer;
    }
    @GetMapping("/customers/username/{username}")
    public Customer getCustomerByUsername (@PathVariable String username)
    {
        Customer theCustomer = customerService.findByUsername(username);

        if( theCustomer == null)
            throw new RuntimeException("Customer with username: "+username+" not found!");

        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer (@RequestBody Customer theCustomer)
    {

        Customer dbCustomer = customerService.save(theCustomer);

        return dbCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer (@PathVariable int customerId)
    {
        Customer theCustomer = customerService.findById(customerId);

        if(theCustomer == null)
            throw  new RuntimeException("This customer doesn't exist!!");

        customerService.deleteById(customerId);

        return "Deleted customer id: " + customerId ;
    }

}

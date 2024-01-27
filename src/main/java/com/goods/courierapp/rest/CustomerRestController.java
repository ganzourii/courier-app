package com.goods.courierapp.rest;

import com.goods.courierapp.models.Customer;
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
    public Customer getEmployee (@PathVariable int customerId)
    {
        Customer theCustomer = customerService.findById(customerId);

        if( theCustomer == null)
            throw new RuntimeException("Employee with id: "+customerId+" not found!");

        return theCustomer;
    }
    @PostMapping("/customers")
    public Customer addEmployee (@RequestBody Customer theCustomer)
    {
        theCustomer.setCustomerId(0);

        Customer dbCustomer = customerService.save(theCustomer);

        return dbCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteEmployee (@PathVariable int customerId)
    {
        Customer theCustomer = customerService.findById(customerId);

        if(theCustomer == null)
            throw  new RuntimeException("This employee doesn't exist!!");

        customerService.deleteById(customerId);

        return "Deleted employee id: " + customerId ;
    }

}

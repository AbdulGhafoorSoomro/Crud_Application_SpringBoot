package com.agscoder.cms.api;


import com.agscoder.cms.model.Customer;
import com.agscoder.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")

public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addcustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //retrive all the customers
    @GetMapping
    public List<Customer> getcustomers(){
        return customerService.getCustomers();
    }

    //retrive customer by Id
    @GetMapping(value = "/(customerId)")
    public Customer getcustomer( @PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    // Update customer
    @PutMapping(value = "/customerId")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    // delete customer

    @DeleteMapping
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }
}

package com.agscoder.cms.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.agscoder.cms.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    private int customerIdCount = 1;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    // Add customer method
    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }

    // Get all customers
    public List<Customer> getCustomers() {
        return customerList;
    }

    // Get a customer by ID
    public Customer getCustomer(int customerId) {
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .orElse(null);  // Return null if customer not found
    }

    // Update customer
    public Customer updateCustomer(int customerId, Customer customer) {
        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });

        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .orElse(null);  // Return null if customer not found after update
    }

    // Delete customer
    public void deleteCustomer(int customerId) {
        List<Customer> customersToRemove = new CopyOnWriteArrayList<>();  // Temporary list for removal

        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        customersToRemove.add(c);  // Collect customers to remove
                    }
                });

        customerList.removeAll(customersToRemove);  // Remove customers after iteration
    }
}

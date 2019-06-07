package pl.coderslab.controller;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Customer;

import java.util.List;

@Component
public interface CustomerRepository {
    void addCustomer(Customer customer);

    void removeCustomer(Customer customer);

    List<Customer> getCustomers();
}

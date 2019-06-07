package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customerList;
    private CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(@Qualifier("dbCustomerLogger") CustomerLogger customerLogger) {
        this.customerList = new ArrayList<>();
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerLogger.log(currentTime() + "dodano klienta " + customer.getFirstName() + " " + customer.getLastName());
        this.customerList.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerLogger.log(currentTime() + "usunięto klienta " + customer.getFirstName() + " " + customer.getLastName());
        this.customerList.remove(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        customerLogger.log(currentTime() + "pobrano listę klientów");
        return this.customerList;
    }

    private String currentTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return "" + hour + ":" + minute + ": ";
    }
}

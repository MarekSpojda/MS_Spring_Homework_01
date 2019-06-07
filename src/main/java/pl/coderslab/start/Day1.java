package pl.coderslab.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.coderslab.controller.DBCustomerRepository;
import pl.coderslab.controller.MemoryCustomerRepository;
import pl.coderslab.controller.SimpleCustomerLogger;
import pl.coderslab.model.Customer;

@Component
public class Day1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        MemoryCustomerRepository repository = (MemoryCustomerRepository) context.getBean("repository");

        Customer newCustomer = new Customer(1, "John", "Snow");
        repository.addCustomer(newCustomer);
        repository.getCustomers();
        repository.removeCustomer(newCustomer);

        Customer newCustomer2 = new Customer(123, "Przemysław", "Ziółkowski");
        DBCustomerRepository dbCustomerRepository = (DBCustomerRepository) context.getBean("customerToRepository");
//        Some entries below put to comment as there is enough entries in database for the moment
//        dbCustomerRepository.addCustomer(newCustomer);
//        dbCustomerRepository.addCustomer(newCustomer2);
//        dbCustomerRepository.removeCustomer(newCustomer2);
        for (Customer localCustomer : dbCustomerRepository.getCustomers()) {
            System.out.println(localCustomer);
        }

        context.close();
    }
}

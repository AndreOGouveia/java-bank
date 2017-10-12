package test.java;

import main.java.services.AuthServiceImpl;
import main.java.services.CustomerServiceImpl;
import main.java.model.Customer;
import main.java.services.CustomerService;

public class AuthServiceTest {

    public boolean test() {

        AuthServiceImpl authService = new AuthServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        authService.setCustomerService(customerService);

        Customer customer = new Customer();
        customerService.add(customer);

        // should authenticate
        authService.authenticate(customer.getId());
        if (authService.getAccessingCustomer() != customer) {
            return false;
        }

        return true;
    }
}

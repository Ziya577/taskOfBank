package az.company.taskofbank.service;

import az.company.taskofbank.entity.Customer;
import az.company.taskofbank.exceptionCustomer.CustomerException;
import az.company.taskofbank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomerService {
    private static final Logger logger = Logger.getLogger(CustomerService.class.getName());


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllData() {
        logger.info("AllDataGet method is running");
        return customerRepository.findAll();


    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> cust = customerRepository.findById(id);
        logger.warning("Maybe your Customid will not find");

       return cust.orElseThrow(() -> new CustomerException("Customer Not Found"));



    }




    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);

    }

    public Customer editCustomer(Long id, Customer customer) {
        Optional<Customer> foundedCustomer = customerRepository.findById(id);
        if (foundedCustomer.isPresent()) {
            Customer newCustomer = foundedCustomer.get();
            newCustomer.setName(customer.getName());
            newCustomer.setSurname(customer.getSurname());
            newCustomer.setBirthDate(customer.getBirthDate());
            newCustomer.setGsmNumber(customer.getGsmNumber());
            customerRepository.save(newCustomer);
            return newCustomer;
        }
return null;

    }
}




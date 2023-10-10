package az.company.taskofbank.controller;

import az.company.taskofbank.entity.Customer;
import az.company.taskofbank.exceptionCustomer.CustomerException;
import az.company.taskofbank.service.CustomerService;
;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
import java.util.logging.Logger.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/all")
    public List<Customer> getAllData(){
        return customerService.getAllData();
    }
    @GetMapping("/getbyid/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/create")

    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
         customerService.deleteById(id);
    }
    @PutMapping("/edit/{id}")
    public Customer editCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.editCustomer(id,customer);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<String> handleCustomerNotFooundException(CustomerException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }


}

package org.bankaccount.customerservice.web;

import org.bankaccount.customerservice.entities.Customer;
import org.bankaccount.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList (){
        return customerRepository.findAll();
    }

    @GetMapping ("customers/{id}")
    public Customer customerById (@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }

}

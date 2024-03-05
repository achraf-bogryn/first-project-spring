package org.bankaccount.customerservice;

import org.bankaccount.customerservice.config.GlobalConfig;
import org.bankaccount.customerservice.entities.Customer;
import org.bankaccount.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

             // 3 Possibility pour cree un customer
            // methode 1 : constructor sans param + setters
//            Customer customer = new Customer();
//            customer.setId();

            // methode 2 : constructor with param   et c pas pratiaue
//            Customer customer = new Customer(null,"","","");

            // methode 3 : Use @Builder annotation pour creat instance of class customer

            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("kawtar")
                            .lastName("NAJI")
                            .email("kawtar@gmail.com")
                            .build(),

                    Customer.builder()
                            .firstName("Hind")
                            .lastName("NA")
                            .email("hind@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }




}

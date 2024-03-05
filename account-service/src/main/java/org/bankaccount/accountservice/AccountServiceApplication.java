package org.bankaccount.accountservice;

import org.bankaccount.accountservice.clients.CustomerRestClient;
import org.bankaccount.accountservice.entities.BankAccount;
import org.bankaccount.accountservice.enums.AccountType;
import org.bankaccount.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(acc->{
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*80000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(acc.getId())
                        .build();

                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*70000)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(acc.getId())
                        .build();
                accountRepository.save(bankAccount1);
                accountRepository.save(bankAccount2);

            });

//            BankAccount bankAccount1 = BankAccount.builder()
//                    .accountId(UUID.randomUUID().toString())
//                    .currency("MAD")
//                    .balance(12345)
//                    .createAt(LocalDate.now())
//                    .type(AccountType.CURRENT_ACCOUNT)
//                    .customerId(Long.valueOf(1))
//                    .build();

//            BankAccount bankAccount2 = BankAccount.builder()
//                    .accountId(UUID.randomUUID().toString())
//                    .currency("MAD")
//                    .balance(12000)
//                    .createAt(LocalDate.now())
//                    .type(AccountType.SAVING_ACCOUNT)
//                    .customerId(Long.valueOf(2))
//                    .build();
//            accountRepository.save(bankAccount1);
//            accountRepository.save(bankAccount2);
        };
    }

}

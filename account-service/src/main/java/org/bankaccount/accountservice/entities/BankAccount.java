package org.bankaccount.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.bankaccount.accountservice.enums.AccountType;
import org.bankaccount.accountservice.model.Customer;

import java.time.LocalDate;
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated (EnumType.STRING)  // stock Account type in database sous form de String
    private AccountType type;
    @Transient // ignorer this attribute exist in class but not be mapped to a database
    private Customer customer;
    private Long customerId;






}

package org.bankaccount.accountservice.repository;

import org.bankaccount.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository <BankAccount, String> {
}

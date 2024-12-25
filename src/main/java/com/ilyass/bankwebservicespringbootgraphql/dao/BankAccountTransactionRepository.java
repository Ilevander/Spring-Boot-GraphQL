package com.ilyass.bankwebservicespringbootgraphql.dao;

import com.ilyass.bankwebservicespringbootgraphql.service.model.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
    List<BankAccountTransaction> findByBankAccount_RibAndCreatedAtBetween(String rib, Date from, Date to);
}

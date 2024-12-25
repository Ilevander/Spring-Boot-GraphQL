package com.ilyass.bankwebservicespringbootgraphql.service.model;

import com.ilyass.bankwebservicespringbootgraphql.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankAccount {
    @Id
    @GeneratedValue
    private Long id;
    private String rib;
    private Double amount;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<BankAccountTransaction> bankAccountTransactionList;
}

package com.ilyass.bankwebservicespringbootgraphql.dtos.transaction;

import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountDto;
import com.ilyass.bankwebservicespringbootgraphql.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionDto {
    private String createdAt;
    private String transactionType;
    private Double amount;
    private BankAccountDto bankAccount;
    private UserDto user;
}

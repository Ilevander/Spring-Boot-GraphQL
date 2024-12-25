package com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount;

import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.CustomerDto;
import com.ilyass.bankwebservicespringbootgraphql.enums.AccountStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddBankAccountResponse {
    private String message;
    private String rib;
    private Double amount;
    private String createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private CustomerDto customer;
}

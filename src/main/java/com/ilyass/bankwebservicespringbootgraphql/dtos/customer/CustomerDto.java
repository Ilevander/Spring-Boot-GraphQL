package com.ilyass.bankwebservicespringbootgraphql.dtos.customer;

import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerDto {
    private String username;
    private String identityRef;
    private String firstname;
    private String lastname;
    private List<BankAccountDto> bankAccounts;
}

package com.ilyass.bankwebservicespringbootgraphql.presentation;

import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountDto;
import com.ilyass.bankwebservicespringbootgraphql.service.IBankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    private final IBankAccountService bankAccountService;

    public BankAccountGraphqlController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @QueryMapping
    List<BankAccountDto> bankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @QueryMapping
    BankAccountDto bankAccountByRib(@Argument String rib) {
        return bankAccountService.getBankAccountByRib(rib);
    }


    @MutationMapping
    public AddBankAccountResponse addBankAccount(@Argument("dto") AddBankAccountRequest dto) {
        return bankAccountService.saveBankAccount(dto);
    }
}

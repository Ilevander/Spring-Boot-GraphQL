package com.ilyass.bankwebservicespringbootgraphql.service;

import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountDto;

import java.util.List;

public interface IBankAccountService {
    AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto);
    List<BankAccountDto> getAllBankAccounts();
    BankAccountDto getBankAccountByRib(String rib);
}

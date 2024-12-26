package com.ilyass.bankwebservicespringbootgraphql.service;

import com.ilyass.bankwebservicespringbootgraphql.dao.BankAccountRepository;
import com.ilyass.bankwebservicespringbootgraphql.dao.CustomerRepository;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.AddBankAccountResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountConverter;
import com.ilyass.bankwebservicespringbootgraphql.dtos.bankaccount.BankAccountDto;
import com.ilyass.bankwebservicespringbootgraphql.enums.AccountStatus;
import com.ilyass.bankwebservicespringbootgraphql.service.exception.BusinessException;
import com.ilyass.bankwebservicespringbootgraphql.service.model.BankAccount;
import com.ilyass.bankwebservicespringbootgraphql.service.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BankAccountServiceImpl implements IBankAccountService{
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    private final BankAccountConverter bankAccountConverter;


    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository, BankAccountConverter bankAccountConverter) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
        this.bankAccountConverter = bankAccountConverter;
    }


    @Override
    public AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto) {
        BankAccount bankAccount = bankAccountConverter.AddBankAccountRequestToBankAccount(dto);
        Customer customerP = customerRepository.findByIdentityRef(bankAccount.getCustomer().getIdentityRef()).orElseThrow(
                () -> new BusinessException(String.format("No customer with the identity: %s exist", dto.getCustomerIdentityRef())));
        bankAccount.setAccountStatus(AccountStatus.OPENED);
        bankAccount.setCustomer(customerP);
        bankAccount.setCreatedAt(new Date());
        AddBankAccountResponse response = bankAccountConverter.bankAccountToAddBankAccountResponse(bankAccountRepository.save(bankAccount));
        response.setMessage(String.format("RIB number [%s] for the customer [%s] has been successfully created", dto.getRib(), dto.getCustomerIdentityRef()));
        return response;
    }

    @Override
    public List<BankAccountDto> getAllBankAccounts() {
        return bankAccountConverter.bankAccountDtos(bankAccountRepository.findAll());
    }

    @Override
    public BankAccountDto getBankAccountByRib(String rib) {
        return bankAccountConverter.bankAccountToBankAccountDTO(bankAccountRepository.findByRib(rib).orElseThrow(
                () -> new BusinessException(String.format("No Bank Account with rib [%s] exist", rib))));
    }
}

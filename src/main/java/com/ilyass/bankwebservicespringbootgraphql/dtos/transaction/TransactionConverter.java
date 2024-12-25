package com.ilyass.bankwebservicespringbootgraphql.dtos.transaction;

import com.ilyass.bankwebservicespringbootgraphql.service.model.BankAccount;
import com.ilyass.bankwebservicespringbootgraphql.service.model.BankAccountTransaction;
import com.ilyass.bankwebservicespringbootgraphql.service.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionConverter {
    private ModelMapper modelMapper;

    public List<TransactionDto> transactionDtos(List<BankAccountTransaction> boList) {
        return boList.stream().map(this::toTransactionDto).collect(Collectors.toList());
    }

    public TransactionDto toTransactionDto(BankAccountTransaction bo) {
        return modelMapper.map(bo, TransactionDto.class);
    }

    public BankAccountTransaction toTransactionFrom(AddWirerTransferRequest dto) {
        return BankAccountTransaction.builder().
                amount(dto.getAmount()).
                user(new User(dto.getUsername())).
                bankAccount(BankAccount.builder().
                        rib(dto.getRibFrom()).
                        build()).
                build();
    }

    public BankAccountTransaction toTransactionTo(AddWirerTransferRequest dto) {
        return BankAccountTransaction.builder().
                amount(dto.getAmount()).
                user(new User(dto.getUsername())).
                bankAccount(BankAccount.builder().
                        rib(dto.getRibTo()).
                        build()).
                build();
    }

    public AddWirerTransferResponse toAddWirerTransferResponse(BankAccountTransaction transactionFrom,
                                                               BankAccountTransaction transactionTo) {
        return AddWirerTransferResponse.builder().

                message(String.format("the transfer of an amount of %s from account %s to account %s was successfully done",
                        transactionFrom.getAmount(),
                        transactionFrom.getBankAccount().getRib(),
                        transactionTo.getBankAccount().getRib())).
                transactionFrom(toTransactionDto(transactionFrom)).
                transactionTo(toTransactionDto(transactionTo)).
                build();
    }
}


package com.ilyass.bankwebservicespringbootgraphql.service;

import com.ilyass.bankwebservicespringbootgraphql.dtos.transaction.AddWirerTransferRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.transaction.AddWirerTransferResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.transaction.TransactionDto;

import java.util.Date;
import java.util.List;

public interface ITransactionService {
    AddWirerTransferResponse wiredTransfer(AddWirerTransferRequest dto);
    List<TransactionDto> getTransactions(String rib, Date dateFrom, Date dateTo);
}

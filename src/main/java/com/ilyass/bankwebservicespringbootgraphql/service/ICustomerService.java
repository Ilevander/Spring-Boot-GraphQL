package com.ilyass.bankwebservicespringbootgraphql.service;

import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.AddCustomerRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.AddCustomerResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.CustomerDto;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();
    AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest);
    CustomerDto getCustomByIdentity(String identity);
}

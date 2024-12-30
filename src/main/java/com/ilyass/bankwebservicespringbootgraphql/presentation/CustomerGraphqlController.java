package com.ilyass.bankwebservicespringbootgraphql.presentation;

import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.AddCustomerRequest;
import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.AddCustomerResponse;
import com.ilyass.bankwebservicespringbootgraphql.dtos.customer.CustomerDto;
import com.ilyass.bankwebservicespringbootgraphql.service.ICustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerGraphqlController {
    private final ICustomerService customerService;

    public CustomerGraphqlController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    List<CustomerDto> customers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    CustomerDto customerByIdentity(@Argument String identity) {
        return customerService.getCustomByIdentity(identity);
    }

    @MutationMapping
    public AddCustomerResponse createCustomer(@Argument("dto") AddCustomerRequest dto) {
        return customerService.createCustomer(dto);
    }
}

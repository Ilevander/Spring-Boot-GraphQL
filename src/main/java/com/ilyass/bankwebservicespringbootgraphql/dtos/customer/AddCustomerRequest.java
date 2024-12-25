package com.ilyass.bankwebservicespringbootgraphql.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddCustomerRequest {
    private String username;
    private String identityRef;
    private String firstname;
    private String lastname;
}

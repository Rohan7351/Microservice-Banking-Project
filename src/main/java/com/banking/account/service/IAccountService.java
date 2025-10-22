package com.banking.account.service;

import com.banking.account.dto.CustomerDto;

public interface IAccountService {
   /**
    *
    * @param customerDto = CustomerDto Object
    */
    void createAccount(CustomerDto customerDto);
}

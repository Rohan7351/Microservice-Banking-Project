package com.banking.account.service.impl;

import com.banking.account.constants.AccountsConstants;
import com.banking.account.dto.CustomerDto;
import com.banking.account.entity.Accounts;
import com.banking.account.entity.Customer;
import com.banking.account.mapper.CustomerMapper;
import com.banking.account.repository.AccountsRepository;
import com.banking.account.repository.CustomerRepository;
import com.banking.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccounServiceImpl implements IAccountService {

    CustomerRepository customerRepository;
    AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
      Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
      Customer savedCustomer = customerRepository.save(customer);
      accountsRepository.save(createNewAccount(savedCustomer));
    }

/**
 *     @param customer  - Customer object
 *     @return the new Account details
 */
  private Accounts createNewAccount(Customer customer) {
      Accounts newAccounts = new Accounts();
      newAccounts.setCustomerId(customer.getCustomerId());
      long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

      newAccounts.setAccountNumber(randomAccNumber);
      newAccounts.setAccountType(AccountsConstants.SAVINGS);
      newAccounts.setBranchAddress(AccountsConstants.ADDRESS);

      return newAccounts;
    }
}

package service;

import dto.CustomerDto;
import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(CustomerDto customerDto);

    Customer findByUsername(String username);

    Customer update(CustomerDto customerDto);

    Customer changePass(CustomerDto customerDto);

    CustomerDto getCustomer(String username);

    List<CustomerDto> findAllCustomer();
}

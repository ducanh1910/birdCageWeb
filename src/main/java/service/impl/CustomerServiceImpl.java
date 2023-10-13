package service.impl;

import dto.CustomerDto;
import model.Customer;
import repository.CustomerRepository;
import repository.RoleRepository;
import service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

    @Override
    public Customer save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPassword(customerDto.getPassword());
        customer.setUserName(customerDto.getUserName());
        customer.setRoles(Arrays.asList(roleRepository.findByName("CUSTOMER")));
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUserName(username);
    }

    @Override
    public CustomerDto getCustomer(String username) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerRepository.findByUserName(username);
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUserName(customer.getUserName());
        customerDto.setPassword(customer.getPassword());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        return customerDto;
    }

    @Override
    public List<CustomerDto> findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map((customer) -> mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }


    private CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        String[] str = customer.getUserName().split(" ");
        customerDto.setFirstName(str[0]);
        customerDto.setLastName(str[1]);
        return customerDto;
    }

    @Override
    public Customer changePass(CustomerDto customerDto) {
        Customer customer = customerRepository.findByUserName(customerDto.getUserName());
        customer.setPassword(customerDto.getPassword());
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto dto) {
        Customer customer = customerRepository.findByUserName(dto.getUserName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        return customerRepository.save(customer);
    }

}

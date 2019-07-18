package com.swedq.customer.customer.service;

import com.swedq.customer.customer.dto.CustomerDTO;
import com.swedq.customer.customer.entity.Customer;
import com.swedq.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;
    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        repository.save(customer);
    }

    @Override
    public CustomerDTO find(Integer id) {
        Optional<Customer> customerEntityOptional = repository.findById(id);
        CustomerDTO customerDTO= null;
        if(customerEntityOptional.isPresent()){
            customerDTO = new CustomerDTO(customerEntityOptional.get());
        }

        return customerDTO;
    }
}

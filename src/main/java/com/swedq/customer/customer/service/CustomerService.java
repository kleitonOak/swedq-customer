package com.swedq.customer.customer.service;

import com.swedq.customer.customer.dto.CustomerDTO;

public interface CustomerService {
    public void save(CustomerDTO customerDTO);
    public CustomerDTO find(Integer id);
}

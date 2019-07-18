package com.swedq.customer.customer.controller;

import com.swedq.customer.customer.dto.CustomerDTO;
import com.swedq.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/customer", headers = "Accept=application/json")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        service.save(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id){
        CustomerDTO customerDTO = service.find(id);
        if(customerDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(customerDTO);
    }


}

package com.swedq.customer.customer.controller;

import com.swedq.customer.customer.dto.CustomerDTO;
import com.swedq.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customer", headers = "Accept=application/json", produces = "application/json")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        service.save(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CustomerDTO>> getCustomers(){
        List<CustomerDTO> customerDTOS = service.findAll();
        if(CollectionUtils.isEmpty(customerDTOS)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(customerDTOS);
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

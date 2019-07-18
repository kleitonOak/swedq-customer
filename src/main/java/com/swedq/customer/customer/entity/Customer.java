package com.swedq.customer.customer.entity;

import com.swedq.customer.address.entity.Address;
import com.swedq.customer.customer.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private List<Address> addresses;

    public Customer(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.addresses = createAddressList(customerDTO);
    }

    private List<Address> createAddressList(CustomerDTO customerDTO){
        List<Address> list = null;
        if(!CollectionUtils.isEmpty(customerDTO.getAddresses())){
            list = customerDTO.getAddresses().stream().map(Address::new ).collect(Collectors.toList());
        }

        return list;
    }
}

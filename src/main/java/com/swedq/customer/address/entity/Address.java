package com.swedq.customer.address.entity;

import com.swedq.customer.address.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String number;
    private String additionalInformation;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @Column(name = "id_customer")
    private Integer idCustomer;

    public Address(AddressDTO addressDTO){
        this.id = addressDTO.getId();
        this.street = addressDTO.getStreet();
        this.number = addressDTO.getNumber();
        this.additionalInformation = addressDTO.getAdditionalInformation();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
        this.country = addressDTO.getCountry();
    }
}

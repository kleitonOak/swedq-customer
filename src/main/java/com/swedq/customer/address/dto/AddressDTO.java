package com.swedq.customer.address.dto;

import com.swedq.customer.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable {
    private Integer id;
    private String street;
    private String number;
    private String additionalInformation;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public AddressDTO(Address entity){
        this.id = entity.getId();
        this.state = entity.getState();
        this.number = entity.getNumber();
        this.additionalInformation = entity.getAdditionalInformation();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.zipCode = entity.getZipCode();
        this.country = entity.getCountry();
    }
}

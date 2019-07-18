package com.swedq.customer.customer.dto;

import com.swedq.customer.address.dto.AddressDTO;
import com.swedq.customer.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private Integer id;
    @NotBlank
    private String name;
    @NotEmpty
    private List<AddressDTO> addresses;

    public CustomerDTO(Customer entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.addresses = createAddressList(entity);
    }

    private List<AddressDTO> createAddressList(Customer entity){
        List<AddressDTO> list = null;
        if(!CollectionUtils.isEmpty(entity.getAddresses())){
            list = entity.getAddresses().stream().map(AddressDTO::new ).collect(Collectors.toList());
        }

        return list;
    }
}

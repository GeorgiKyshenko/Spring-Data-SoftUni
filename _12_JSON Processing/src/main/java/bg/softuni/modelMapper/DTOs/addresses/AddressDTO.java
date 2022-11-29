package bg.softuni.modelMapper.DTOs.addresses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO extends CreateAddressDTO {

    private long id;

    public AddressDTO() {
        super();
    }

    public AddressDTO(String country, String city) {
        super(country, city);
    }
}

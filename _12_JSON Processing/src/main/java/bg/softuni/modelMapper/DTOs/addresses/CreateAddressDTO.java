package bg.softuni.modelMapper.DTOs.addresses;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressDTO {
    @Expose
    private String country;
    @Expose
    private String city;

    public CreateAddressDTO() {
    }

    public CreateAddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }
}


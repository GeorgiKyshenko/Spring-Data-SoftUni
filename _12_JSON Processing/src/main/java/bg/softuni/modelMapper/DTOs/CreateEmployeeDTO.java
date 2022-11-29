package bg.softuni.modelMapper.DTOs;

import bg.softuni.modelMapper.DTOs.addresses.CreateAddressDTO;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreateEmployeeDTO {

    @Expose
    private String firstName;
    @Expose
    private String lasName;
    @Expose
    private BigDecimal salary;
    @Expose
    private LocalDate birthday;
    @Expose
    private CreateAddressDTO address;

    public CreateEmployeeDTO(String firstName, String lasName, BigDecimal salary, LocalDate birthday, CreateAddressDTO address) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }
}

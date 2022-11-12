package bg.softuni.modelMapper.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreateEmployeeDTO {

    private String firstName;

    private String lasName;

    private BigDecimal salary;

    private LocalDate birthday;

    private AddressDTO address;

    public CreateEmployeeDTO(String firstName, String lasName, BigDecimal salary, LocalDate birthday, AddressDTO address) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }
}

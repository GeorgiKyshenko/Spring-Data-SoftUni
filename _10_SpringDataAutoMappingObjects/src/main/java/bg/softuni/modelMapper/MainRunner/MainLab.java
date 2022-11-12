package bg.softuni.modelMapper.MainRunner;

import bg.softuni.modelMapper.DTOs.AddressDTO;
import bg.softuni.modelMapper.DTOs.CreateEmployeeDTO;
import bg.softuni.modelMapper.entities.Address;
import bg.softuni.modelMapper.entities.Employee;
import bg.softuni.modelMapper.services.AddressService;
import bg.softuni.modelMapper.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class MainLab implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    private final Scanner scanner;

    @Autowired
    public MainLab(AddressService addressService, EmployeeService employeeService, Scanner scanner) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        createAddress();
//        createEmployee();
//        printAllEmployees();

    }

    private void printAllEmployees() {
        employeeService.findAll().forEach(System.out::println);
    }

    private void createEmployee() {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

//        long addressId = Long.parseLong(scanner.nextLine()); ако искаме да намираме град по ID в базата данни.

        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO addressData = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, addressData);

        Employee employee = employeeService.create(employeeDTO);

        System.out.println(employee);
    }

    private void createAddress() {
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO addressData = new AddressDTO(country, city);

        Address address = addressService.create(addressData);

        System.out.println(address);
    }
}

package bg.softuni.modelMapper.MainRunner;

import bg.softuni.modelMapper.DTOs.addresses.AddressDTO;
import bg.softuni.modelMapper.DTOs.addresses.CreateAddressDTO;
import bg.softuni.modelMapper.DTOs.CreateEmployeeDTO;
import bg.softuni.modelMapper.entities.Address;
import bg.softuni.modelMapper.entities.Employee;
import bg.softuni.modelMapper.services.AddressService;
import bg.softuni.modelMapper.services.EmployeeService;
import com.google.gson.Gson;
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
    private final Gson gson;

    @Autowired
    public MainLab(AddressService addressService, EmployeeService employeeService, Scanner scanner, Gson gson) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.scanner = scanner;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {

        createAddress();
//        createEmployee();
//        printAllEmployees();
//        printEmployeeNames();

    }

    private void printEmployeeNames() {
        System.out.println(employeeService.findNamesById(1L));
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

        CreateAddressDTO addressData = new CreateAddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, addressData);

        Employee employee = employeeService.create(employeeDTO);

        System.out.println(employee);
    }

    private void createAddress() {
/*      String country = scanner.nextLine();
        String city = scanner.nextLine();
        AddressDTO addressData = new AddressDTO(country, city);
         --> създаване на AddressDTO чрез четене на стрингове от конзолата*/


        // създаване на AddressDTO чрез подаване на JSON формат през конзолата!
        String input = this.scanner.nextLine();
        CreateAddressDTO createAddressDTOFromJson = this.gson.fromJson(input, CreateAddressDTO.class);
        /*1.Създаваме CreateAddressDTO от JSON input.
        * 2. Преобразуваме го в AddressDTO (който има field id), за да можем да го създадем и запазим в базата
        * 3. Връщаме запазеният адрес(обект), като го мапваме отново към AddressDTO (в create метода)
        * 4. С System.out.println го връщаме на потребителя.*/
        AddressDTO created = addressService.create(createAddressDTOFromJson);

        System.out.println(gson.toJson(created));
    }
}
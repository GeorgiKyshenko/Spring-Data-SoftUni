package bg.softuni.modelMapper.MainRunner;

import bg.softuni.modelMapper.DTOs.EmployeeDTO;
import bg.softuni.modelMapper.entities.Address;
import bg.softuni.modelMapper.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class ModelMapperMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("Jayson", BigDecimal.valueOf(2.543), address);

        ModelMapper mapper = new ModelMapper();


//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                map().setCity(source.getAddress().getCity());
//                /*map() is the destination object(EmployeeDTO)
//                * "source" is Source object(Employee) */
//            }
//        };
//        mapper.addMappings(propertyMap);
//
//        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);


        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(mapping -> mapping.map(source -> source.getAddress().getCity(), EmployeeDTO::setAddressCity));
//      typeMap.validate(); - валидира дали всички полета ще се set-нат коректно!

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);
    }
}

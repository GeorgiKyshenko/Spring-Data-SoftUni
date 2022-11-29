package bg.softuni.modelMapper.services;

import bg.softuni.modelMapper.DTOs.CreateEmployeeDTO;
import bg.softuni.modelMapper.DTOs.EmployeeDTO;
import bg.softuni.modelMapper.DTOs.EmployeeNamesDTO;
import bg.softuni.modelMapper.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();

    EmployeeNamesDTO findNamesById(long l);
}

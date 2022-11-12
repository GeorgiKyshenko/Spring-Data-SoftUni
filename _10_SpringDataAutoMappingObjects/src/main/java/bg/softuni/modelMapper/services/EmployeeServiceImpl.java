package bg.softuni.modelMapper.services;

import bg.softuni.modelMapper.DTOs.CreateEmployeeDTO;
import bg.softuni.modelMapper.DTOs.EmployeeDTO;
import bg.softuni.modelMapper.entities.Address;
import bg.softuni.modelMapper.entities.Employee;
import bg.softuni.modelMapper.repositories.AddressRepository;
import bg.softuni.modelMapper.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    //Transactional изпълнява няколко заявки едновременно като в този случай имаме -> employeeRepository.save(employee); и в Employee -> address -> CascadeType.Persist
    public Employee create(CreateEmployeeDTO employeeDTO) {

        Employee employee = mapper.map(employeeDTO, Employee.class);

        Optional<Address> address = addressRepository.findByCountryAndCity(employeeDTO.getAddress().getCountry(),
                employeeDTO.getAddress().getCity());

        address.ifPresent(employee::setAddress);

        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream().map(e -> mapper.map(e, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}

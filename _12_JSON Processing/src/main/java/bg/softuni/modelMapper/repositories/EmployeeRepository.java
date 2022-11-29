package bg.softuni.modelMapper.repositories;

import bg.softuni.modelMapper.DTOs.EmployeeNamesDTO;
import bg.softuni.modelMapper.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select new bg.softuni.modelMapper.DTOs.EmployeeNamesDTO(e.firstName, e.lastName) from employee as e where e.id = :id")
    EmployeeNamesDTO findNamesById(long id);
}

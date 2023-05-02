package fuku.frey.springbackend.service.impl;

import fuku.frey.springbackend.entity.Employee;
import fuku.frey.springbackend.exception.ResourceNotFoundException;
import fuku.frey.springbackend.repository.EmployeeRepository;
import fuku.frey.springbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeId(long id) {
//        Optional<Employee> employee=employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }
//        throw new ResourceNotFoundException("Employee","Id",id);
        return employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee=employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
//        return employeeRepository.;
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
//     To check if exist or not
       employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}

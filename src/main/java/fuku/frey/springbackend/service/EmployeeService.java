package fuku.frey.springbackend.service;

import fuku.frey.springbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeId(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}

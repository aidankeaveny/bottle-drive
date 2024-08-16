package com.aidan.crud_backend.service.impl;

import com.aidan.crud_backend.dto.EmployeeDto;
import com.aidan.crud_backend.entity.Employee;
import com.aidan.crud_backend.exception.ResourceNotFoundException;
import com.aidan.crud_backend.mapper.EmployeeMapper;
import com.aidan.crud_backend.repository.EmployeeRepository;
import com.aidan.crud_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    private Employee findEmployeeById(Long pEmployeeId) {
        return employeeRepository.findById(pEmployeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with given id: "+ pEmployeeId + "does not exist"));
    }

    @Override
    public EmployeeDto getEmployeeById(Long pEmployeeId) {
        Employee employee = findEmployeeById(pEmployeeId);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long pEmployeeId, EmployeeDto pEmployeeDto) {
        Employee employee = findEmployeeById(pEmployeeId);
        employee.setFirstName(pEmployeeDto.getFirstName());
        employee.setLastName(pEmployeeDto.getLastName());
        employee.setEmail(pEmployeeDto.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long pEmployeeId) {
        Employee employee = findEmployeeById(pEmployeeId);
        employeeRepository.delete(employee);
    }

}

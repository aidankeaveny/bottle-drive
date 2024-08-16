package com.aidan.crud_backend.service;

import com.aidan.crud_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto pEmployeeDto);

    EmployeeDto getEmployeeById(Long pEmployeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long pEmployeeId, EmployeeDto pEmployeeDto);

    void deleteEmployee(Long pEmployeeId);
}

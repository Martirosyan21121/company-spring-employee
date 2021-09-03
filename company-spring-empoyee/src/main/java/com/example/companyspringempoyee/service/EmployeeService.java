package com.example.companyspringempoyee.service;

import com.example.companyspringempoyee.model.Employee;
import com.example.companyspringempoyee.repazitory.EmployeeRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepazitory employeeRepazitory;

    public void save(Employee employee){
        employeeRepazitory.save(employee);

    }
    public List<Employee> findAll(){
        return employeeRepazitory.findAll();
    }

    public void deleteAllByCompanyId(int id) {
        employeeRepazitory.deleteAllByCompanyId(id);
    }

    public List<Employee> findEmployeeByCompanyId(int companyId){
        return employeeRepazitory.findEmployeeByCompanyId(companyId);
    }
    public Optional<Employee> findEmployeeById(int id) {
        return employeeRepazitory.findById(id);

    }
}

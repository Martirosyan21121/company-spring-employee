package com.example.companyspringempoyee.security;

import com.example.companyspringempoyee.model.Employee;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {

    private final Employee employee;

    public SecurityUser(Employee employee) {
        super(employee.getEmail(), employee.getPassword(), AuthorityUtils.createAuthorityList(employee.getEmployeeType().name()));
        this.employee = employee;
    }

    public Employee getEmployee(){
        return employee;
    }
}

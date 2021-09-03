package com.example.companyspringempoyee.security;

import com.example.companyspringempoyee.model.Employee;
import com.example.companyspringempoyee.repazitory.EmployeeRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final EmployeeRepazitory employeeRepazitory;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Employee> byEmail = employeeRepazitory.findByEmail(s);
        if (!byEmail.isPresent()){
            throw new UsernameNotFoundException("Employee with" + s + "email does not exist!");
        }
        return new SecurityUser(byEmail.get());
    }
}

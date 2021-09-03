package com.example.companyspringempoyee;

import com.example.companyspringempoyee.model.Company;
import com.example.companyspringempoyee.model.Employee;
import com.example.companyspringempoyee.model.EmployeeType;
import com.example.companyspringempoyee.repazitory.CompanyRemazitory;
import com.example.companyspringempoyee.repazitory.EmployeeRepazitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompanySpringEmpoyeeApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepazitory employeeRepazitory;

    @Autowired
    private CompanyRemazitory companyRemazitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(CompanySpringEmpoyeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (!employeeRepazitory.findByEmail("admin").isPresent()) {
            Company company = companyRemazitory.save(Company.builder()
                    .name("Default Company")
                    .address("Default Address")
                    .build());

            employeeRepazitory.save(Employee.builder()
                    .email("admin")
                    .phoneNumber(1200)
                    .surname("Martirosyan")
                    .name("admin")
                    .password(passwordEncoder.encode("admin"))
                    .position("admin")
                    .employeeType(EmployeeType.ADMIN)
                    .companyId(company)
                    .build());
        }
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

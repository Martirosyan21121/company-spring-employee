package com.example.companyspringempoyee.controlier;

import com.example.companyspringempoyee.model.Company;
import com.example.companyspringempoyee.model.Employee;
import com.example.companyspringempoyee.security.SecurityUser;
import com.example.companyspringempoyee.service.CompanyService;
import com.example.companyspringempoyee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeControlier {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/employee")
    public String getEmployees(ModelMap modelMap, @AuthenticationPrincipal SecurityUser securityUser) {
        List<Employee> all = employeeService.findEmployeeByCompanyId(securityUser.getEmployee().getCompanyId().getId());
        modelMap.addAttribute("employees", all);
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap modelMap) {
        List<Company> all = companyService.findAll();
        modelMap.addAttribute("companies", all);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.save(employee);
        Company company = companyService.getById(employee.getCompanyId().getId());
        company.setSize(company.getSize() + 1);
        companyService.saveCompany(company);
        return "redirect:/employee";
    }
}

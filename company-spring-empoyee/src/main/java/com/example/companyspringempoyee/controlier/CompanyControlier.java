package com.example.companyspringempoyee.controlier;

import com.example.companyspringempoyee.model.Company;
import com.example.companyspringempoyee.service.CompanyService;
import com.example.companyspringempoyee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyControlier {
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @GetMapping("/company")
    public String getCompanies(ModelMap modelMap) {
        List<Company> all = companyService.findAll();
        modelMap.addAttribute("companies", all);
        return "company";
    }
    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyService.saveCompany(company);
        return "redirect:/company";
    }

    @GetMapping("/deleteCompany/{id}")
    @Transactional
    public String deleteCompany(@PathVariable("id") int id){
        employeeService.deleteAllByCompanyId(id);
        companyService.deleteById(id);
        return "redirect:/company";
    }
}

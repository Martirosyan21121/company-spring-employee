package com.example.companyspringempoyee.service;

import com.example.companyspringempoyee.model.Company;
import com.example.companyspringempoyee.repazitory.CompanyRemazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRemazitory companyRemazitory;

    public void saveCompany(Company company){
        companyRemazitory.save(company);
    }

    public List<Company> findAll(){
        return companyRemazitory.findAll();
    }
    public Company getById(int id){
    return companyRemazitory.getById(id);
    }
    public void deleteById(int id){
        companyRemazitory.deleteById(id);
    }

}

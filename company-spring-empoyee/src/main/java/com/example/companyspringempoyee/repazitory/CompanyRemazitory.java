package com.example.companyspringempoyee.repazitory;

import com.example.companyspringempoyee.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRemazitory extends JpaRepository<Company, Integer> {
}

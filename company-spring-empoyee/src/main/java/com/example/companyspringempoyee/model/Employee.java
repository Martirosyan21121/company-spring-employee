package com.example.companyspringempoyee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private int salary;
    @JoinColumn(name = "phone_number")
    private int phoneNumber;
    private String position;
    @Enumerated(value = EnumType.STRING)
    @JoinColumn(name = "employee_type")
    private EmployeeType employeeType;
    private String password;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
}

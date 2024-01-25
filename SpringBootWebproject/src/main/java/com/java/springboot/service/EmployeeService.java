package com.java.springboot.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import com.java.springboot.DTO.EmployeeDTO;
import com.java.springboot.entity.Employee;

public interface EmployeeService  {
 public String AddEmployee(EmployeeDTO dto);
 public List<EmployeeDTO> ViewAllemployeeData();
 public List<EmployeeDTO> viewallemployeedetailsbyid(Integer empid);
 

}

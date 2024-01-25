package com.java.springboot.service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.java.springboot.DTO.EmployeeDTO;
import com.java.springboot.entity.Employee;
import com.java.springboot.repository.EmployeeRespository;

import jakarta.transaction.Transactional;
@Service(value="EmployeeService")
@Transactional
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	EmployeeRespository employeerepository;

	@Override
	public String AddEmployee(EmployeeDTO dto) {
		Employee employee=new Employee();
		employee.setEmpname(dto.getEmpname());
		employee.setDesignation(dto.getDesignation());
		employee.setSalary(dto.getSalary());
		employeerepository.save(employee);
		Integer id=employeerepository.save(employee).getEmpid();
		return "Employee Added Successfully";
	}

	@Override
	public List<EmployeeDTO> ViewAllemployeeData() {
		Iterable<Employee> allempdetails=employeerepository.findAll();
		List<EmployeeDTO> empdto=new ArrayList<EmployeeDTO>();
		allempdetails.forEach(e->empdto.add(new EmployeeDTO(e.getEmpid(), e.getEmpname(), e.getDesignation(),e.getSalary())));
		if(empdto.isEmpty()) {
			throw new RuntimeException("No Employees data found");
		}
		return empdto;
	}

	@Override
	public List<EmployeeDTO> viewallemployeedetailsbyid(Integer empid) {
	Optional<Employee> list=	employeerepository.findById(empid);
	Employee empdata=list.orElseThrow(()-> new RuntimeException("No data were matched with the empid"+empid));
		
		List<Employee> addlist=new ArrayList<Employee>();
addlist.add(empdata);
		return addlist.stream().map(a->new EmployeeDTO(a.getEmpid(),a.getEmpname(), a.getDesignation(), a.getSalary())).collect(Collectors.toList());
		
	}

	
	

}

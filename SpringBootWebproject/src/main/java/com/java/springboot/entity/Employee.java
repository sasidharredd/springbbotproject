package com.java.springboot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employeedetails")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String empname;
	private String designation;
	private Float salary;
	public Integer getEmpid() {
		return empid;
	}
	public String getEmpname() {
		return empname;
	}
	public String getDesignation() {
		return designation;
	}
	
	public Float getSalary() {
		return salary;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setSalary(Float salary) {
		this.salary = salary;
	}


}

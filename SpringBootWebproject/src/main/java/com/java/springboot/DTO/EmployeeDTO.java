package com.java.springboot.DTO;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public EmployeeDTO(String empname, String designation,  Float salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
		this.salary = salary;
	}
	public EmployeeDTO(Integer empid, String empname, String designation, Float salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empid=" + empid + ", empname=" + empname + ", designation=" + designation + ", salary="
				+ salary + "]";
	}

}

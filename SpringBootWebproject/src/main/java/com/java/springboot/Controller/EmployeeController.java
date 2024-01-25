package com.java.springboot.Controller;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.DTO.EmployeeDTO;
import com.java.springboot.service.EmployeeService;
@RestController
//@RequestMapping(value="base-url")
public class EmployeeController {
	Log logger=LogFactory.getLog(this.getClass());
	@Autowired
	EmployeeService employeeservice;
	
	public void Addemployee() {
		System.out.println("Enter the employee details");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee name:");
		String s=sc.next();
		System.out.println("Enter the designation of the employee:");
		String desg=sc.next();
		System.out.println("Enter the salary");
		Float salary=sc.nextFloat();
		EmployeeDTO dto=new EmployeeDTO(s, desg, salary);
		String succ=employeeservice.AddEmployee(dto);
		System.out.println(succ);
		}
	
	@GetMapping(value="/demo")
	public String demoMethodformultiplerequestparam(@RequestParam String fname, @RequestParam String Lname,@RequestParam String email,@RequestParam String phnum,@RequestParam String street) {
		logger.info("Demo method called");
		System.out.println(String.format("print the method parameters-->fname-%s,Lname %s,email %s,phnum %s,street %s",fname,Lname,email,phnum,street));
		return "Demo method called successfully user";
	}
	@GetMapping(value="/login")
	public String demologin1(@RequestParam String username, @RequestParam String password) {
		logger.info("Demo login method called");
		return "login get method called successfully"+String.format("print the method parameters-->uname -%s,pword -%s",username,password);
	}
	
	
	@PostMapping(value="/login")
	public String demologin(@RequestParam String username, @RequestParam String password) {
		logger.info("Demo postlogin method called");
		System.out.println(String.format("print the method parameters-->uname-%s,pword-%s",username,password));
		return "Post demo called successfully"+String.format("print the method parameters-->username-%s,password-%s",username,password);
	}
	
	
	//@PostMapping(value="/login")
	public String demoMethodformultiplerequestparam1(@RequestParam String fname, @RequestParam String Lname,@RequestParam String email,@RequestParam String phnum,@RequestParam String street) {
		logger.info("Demo method called");
		System.out.println(String.format("print the method parameters-->fname-%s,Lname %s,email %s,phnum %s,street %s",fname,Lname,email,phnum,street));
		return "Post demo called successfully"+String.format("print the method parameters-->fname-%s,Lname %s,email %s,phnum %s,street %s",fname,Lname,email,phnum,street);
	}
	@RequestMapping(method=RequestMethod.GET,value="/get-empdata")
	//@ResponseBody
public  List<EmployeeDTO> viewallEmployees() {
		logger.info("get Employees method called");

	return employeeservice.ViewAllemployeeData();
	//list.stream().forEach(System.out::println);
	
}
	//Requestparam
//	@GetMapping(value="/sort")
//	public List<EmployeeDTO> fetchemployeedetailsbyempid(@RequestParam(name="empid")  Integer empid){
//		logger.info("get Employees method called");
//		return employeeservice.viewallemployeedetailsbyid(empid);
//	}
	//Pathvariable/employee-app/sort/
	@GetMapping(value="/sort/{empID}")
	public List<EmployeeDTO> fetchemployeedetailsbyempid(@PathVariable(value="empID") Integer empid){
		logger.info("get Employees method called");
		return employeeservice.viewallemployeedetailsbyid(empid);
	}
}

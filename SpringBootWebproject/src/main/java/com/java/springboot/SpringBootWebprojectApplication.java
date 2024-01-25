package com.java.springboot;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.java.springboot.Controller.EmployeeController;

@SpringBootApplication
public class SpringBootWebprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=    SpringApplication.run(SpringBootWebprojectApplication.class, args);
EmployeeController con=context.getBean(EmployeeController.class);
//con.Addemployee();
//con.viewallEmployees();
}

}

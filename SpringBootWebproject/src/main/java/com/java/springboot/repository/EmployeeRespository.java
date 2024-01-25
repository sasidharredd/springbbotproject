package com.java.springboot.repository;

import java.awt.print.Pageable;
import java.time.LocalDate;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.entity.Employee;
@Repository
public interface EmployeeRespository extends CrudRepository<Employee,Integer> {

}

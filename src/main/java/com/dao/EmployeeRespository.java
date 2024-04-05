package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

	Employee findByEmailId(String EmailId);

}

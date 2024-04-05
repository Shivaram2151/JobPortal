package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Jobpost;

@Repository
public interface JobPostRepository extends JpaRepository<Jobpost, Integer> {

	List<Jobpost> findByLocation(String location);	

	List<Jobpost> findBySalaryGreaterThanEqual(double salary);

	List<Jobpost> findBySkillsContaining(String skills);

	List<Jobpost> findByExperienceLessThanEqual(int experience);

	List<Jobpost> findByCompanyName(String company);


}

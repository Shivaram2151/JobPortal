package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Jobpost;

@Service
public class EmpJobDao {

	@Autowired
	JobPostRepository jobPostRepository;
	
	@Autowired
	EmailService emailService;
	
	public Jobpost empJobPostReg(Jobpost jobpost){
		
		Jobpost jobpost2 = jobPostRepository.save(jobpost);
		emailService.emailjobposted(jobpost.getEmailId(), jobpost);
		return jobpost2;
	}
	
	public List<Jobpost> findAll(){
		return jobPostRepository.findAll();
	}
	
	public List<Jobpost> findByLocation(String location){
		return jobPostRepository.findByLocation(location);
	}
	
	public List<Jobpost> findBySalaryGreaterThanEqual(double salary){
		return jobPostRepository.findBySalaryGreaterThanEqual(salary);
	}
	
	public List<Jobpost> findBySkillsContaining(String skills){
		return jobPostRepository.findBySkillsContaining(skills);
	}
	
	public List<Jobpost> findByExperienceLessThanEqual(int experience){
		return jobPostRepository.findByExperienceLessThanEqual(experience);
	}
	
	public List<Jobpost> findByCompany(String company){
		return jobPostRepository.findByCompanyName(company);
	}
	
	public Jobpost findById(int Id){
		return jobPostRepository.findById(Id).orElse(new Jobpost("",0,"",0,0.0,"","",0,"","","","",new Date(),"","","","","",""));
	}
	
}

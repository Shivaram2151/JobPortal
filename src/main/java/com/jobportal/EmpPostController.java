package com.jobportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmpJobDao;
import com.model.Jobpost;

@RestController
public class EmpPostController {

	@Autowired
	EmpJobDao dao;

	@PostMapping("jobReg")
	public Jobpost jobReg(@RequestBody Jobpost jobpost){
		return dao.empJobPostReg(jobpost);
	}

	@GetMapping("getAll")
	public List<Jobpost> findAll(){
		return dao.findAll();
	}

	@GetMapping("findByLocation/{location}")
	public List<Jobpost> findByLocation(@PathVariable("location") String location){
		return dao.findByLocation(location);

	}

	@GetMapping("findBySalary/{salary}")
	public List<Jobpost> findBySalary(@PathVariable("salary") double salary){
		return dao.findBySalaryGreaterThanEqual(salary);

	}

	@GetMapping("findBySkills/{skills}")
	public List<Jobpost> findBySkillsContaining(@PathVariable("skills") String skills){
		return dao.findBySkillsContaining(skills);

	}

	@GetMapping("findByExperience/{experience}")
	public List<Jobpost> findByExperienceLessThanEqual(@PathVariable("experience") int experience){
		return dao.findByExperienceLessThanEqual(experience);

	}

	@GetMapping("findByCompany/{company}")
	public List<Jobpost> findByCompany(@PathVariable("company") String company){
		return dao.findByCompany(company);

	}

	@GetMapping("find/{id}")
	public Jobpost find(@PathVariable("id")int id){
		return dao.findById(id);
	}


}

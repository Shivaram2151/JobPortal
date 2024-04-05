package com.jobportal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.JobApplyDao;
import com.model.jobApplication;

@RestController
public class ApplyController {

	@Autowired
	JobApplyDao jobDao;


	@PostMapping("jobApply")
	public jobApplication jobApply(@RequestBody jobApplication application){
		return jobDao.jobapply(application);
	}

	@GetMapping("get/{id}")
	public Optional<jobApplication> getById(@PathVariable("id") int id){
		return jobDao.getById(id);
	}
}

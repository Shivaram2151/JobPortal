package com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.jobApplication;

@Service
public class JobApplyDao {

	@Autowired
	JobApplyRepository applyRepository;

	@Autowired
	EmailService emailService;

	public jobApplication jobapply(jobApplication application){
		jobApplication application2 = applyRepository.save(application);
		emailService.emailJobApplied(application.getEmailId(), application);
		return application2;
	}

	public Optional<jobApplication> getById(int id){
		return applyRepository.findById(id);
	}



}

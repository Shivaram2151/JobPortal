package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.jobApplication;

@Repository
public interface JobApplyRepository extends JpaRepository<jobApplication, Integer> {


}

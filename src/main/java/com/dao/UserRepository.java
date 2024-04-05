package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String EmailId);

	@Query("from User where emailId= :emailid")
	User findbyemailid(@Param("emailid") String emailid);
}

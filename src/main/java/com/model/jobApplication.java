package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class jobApplication {

	@Id@GeneratedValue
	private int id;

	private String fullName;
	private Date dateOfBirth;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String LinkedInURL;
	private String address;


	private String schoolName;
	private String SchoolPercentage;
	private String CollegeName;
	private String collPercentage;
	private String graduationInstitute;
	private String graduationPercentage;
	private String GraduationPassedOut;


	public jobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public jobApplication(int id, String fullName, Date dateOfBirth, String gender, String emailId, String phoneNumber,
			String linkedInURL, String address, String schoolName, String schoolPercentage, String collegeName,
			String collPercentage, String graduationInstitute, String graduationPercentage, String graduationPassedOut) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.LinkedInURL = linkedInURL;
		this.address = address;
		this.schoolName = schoolName;
		this.SchoolPercentage = schoolPercentage;
		this.CollegeName = collegeName;
		this.collPercentage = collPercentage;
		this.graduationInstitute = graduationInstitute;
		this.graduationPercentage = graduationPercentage;
		this.GraduationPassedOut = graduationPassedOut;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLinkedInURL() {
		return LinkedInURL;
	}

	public void setLinkedInURL(String linkedInURL) {
		LinkedInURL = linkedInURL;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolPercentage() {
		return SchoolPercentage;
	}

	public void setSchoolPercentage(String schoolPercentage) {
		SchoolPercentage = schoolPercentage;
	}

	public String getCollegeName() {
		return CollegeName;
	}

	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}

	public String getCollPercentage() {
		return collPercentage;
	}

	public void setCollPercentage(String collPercentage) {
		this.collPercentage = collPercentage;
	}

	public String getGraduationInstitute() {
		return graduationInstitute;
	}

	public void setGraduationInstitute(String graduationInstitute) {
		this.graduationInstitute = graduationInstitute;
	}

	public String getGraduationPercentage() {
		return graduationPercentage;
	}

	public void setGraduationPercentage(String graduationPercentage) {
		this.graduationPercentage = graduationPercentage;
	}

	public String getGraduationPassedOut() {
		return GraduationPassedOut;
	}

	public void setGraduationPassedOut(String graduationPassedOut) {
		GraduationPassedOut = graduationPassedOut;
	}
}

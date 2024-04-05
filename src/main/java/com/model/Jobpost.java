package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jobpost {

	//basic job details.
	@Id
	@GeneratedValue
	private int postId;

	@Column(nullable = false)
	private String jobTitle;

	@Column(nullable = false)
	private int numberOfOpenings;

	@Column(nullable = false)
	private String location;

	//candidate requirements
	@Column(nullable = false)
	private int experience;

	@Column(nullable = false)
	private double salary;

	@Column(nullable = false)
	private String jobDescription;	

	@Column(nullable = false)
	private String skills;

	//personal details,education..
	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String preferredLanguage;

	@Column(nullable = false)
	private String degree_specialisation;

	@Column(nullable = false)
	private String certification;

	//timings
	@Column(nullable = false)
	private String jobTimings;

	@Temporal(TemporalType.DATE)
	private Date lastDate;

	//company details
	@Column(nullable = false)
	private String companyName;

	@Column(nullable = false)
	private String personName;

	@Column(nullable = false)
	private String PhoneNumber;

	@Column(nullable = false)
	private String emailId;

	@Column(nullable = false)
	private String contact_Person_Profile;

	@Column(nullable = false)
	private String jobAddress;

	@Column(nullable = false)
	private boolean status;


	public Jobpost() {
		super();
	}


	public Jobpost(int postId, String jobTitle, int numberOfOpenings, String location, int experience, double salary,
			String jobDescription, String skills, int age, String preferredLanguage, String degree_specialisation,
			String certification, String jobTimings, Date lastDate, String companyName, String personName,
			String phoneNumber, String emailId, String contact_Person_Profile, String jobAddress, boolean status) {
		super();
		this.postId = postId;
		this.jobTitle = jobTitle;
		this.numberOfOpenings = numberOfOpenings;
		this.location = location;
		this.experience = experience;
		this.salary = salary;
		this.jobDescription = jobDescription;
		this.skills = skills;
		this.age = age;
		this.preferredLanguage = preferredLanguage;
		this.degree_specialisation = degree_specialisation;
		this.certification = certification;
		this.jobTimings = jobTimings;
		this.lastDate = lastDate;
		this.companyName = companyName;
		this.personName = personName;
		this.PhoneNumber = phoneNumber;
		this.emailId = emailId;
		this.contact_Person_Profile = contact_Person_Profile;
		this.jobAddress = jobAddress;
		this.status = status;
	}


	public Jobpost(String jobTitle, int numberOfOpenings, String location, int experience, double salary,
			String jobDescription, String skills, int age, String preferredLanguage, String degree_specialisation,
			String certification, String jobTimings, Date lastDate, String companyName, String personName,
			String phoneNumber, String emailId, String contact_Person_Profile, String jobAddress, boolean status) {
		super();
		this.jobTitle = jobTitle;
		this.numberOfOpenings = numberOfOpenings;
		this.location = location;
		this.experience = experience;
		this.salary = salary;
		this.jobDescription = jobDescription;
		this.skills = skills;
		this.age = age;
		this.preferredLanguage = preferredLanguage;
		this.degree_specialisation = degree_specialisation;
		this.certification = certification;
		this.jobTimings = jobTimings;
		this.lastDate = lastDate;
		this.companyName = companyName;
		this.personName = personName;
		this.PhoneNumber = phoneNumber;
		this.emailId = emailId;
		this.contact_Person_Profile = contact_Person_Profile;
		this.jobAddress = jobAddress;
		this.status = status;
	}

	public Jobpost(String jobTitle, int numberOfOpenings, String location, int experience, double salary,
			String jobDescription, String skills, int age, String preferredLanguage, String degree_specialisation,
			String certification, String jobTimings, Date lastDate, String companyName, String personName,
			String phoneNumber, String emailId, String contact_Person_Profile, String jobAddress) {
		super();
		this.jobTitle = jobTitle;
		this.numberOfOpenings = numberOfOpenings;
		this.location = location;
		this.experience = experience;
		this.salary = salary;
		this.jobDescription = jobDescription;
		this.skills = skills;
		this.age = age;
		this.preferredLanguage = preferredLanguage;
		this.degree_specialisation = degree_specialisation;
		this.certification = certification;
		this.jobTimings = jobTimings;
		this.lastDate = lastDate;
		this.companyName = companyName;
		this.personName = personName;
		this.PhoneNumber = phoneNumber;
		this.emailId = emailId;
		this.contact_Person_Profile = contact_Person_Profile;
		this.jobAddress = jobAddress;
	}
	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getDegree_specialisation() {
		return degree_specialisation;
	}

	public void setDegree_specialisation(String degree_specialisation) {
		this.degree_specialisation = degree_specialisation;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getJobTimings() {
		return jobTimings;
	}

	public void setJobTimings(String jobTimings) {
		this.jobTimings = jobTimings;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact_Person_Profile() {
		return contact_Person_Profile;
	}

	public void setContact_Person_Profile(String contact_Person_Profile) {
		this.contact_Person_Profile = contact_Person_Profile;
	}

	public String getJobAddress() {
		return jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

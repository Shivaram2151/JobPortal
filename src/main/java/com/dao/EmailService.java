package com.dao;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.model.Jobpost;
import com.model.User;
import com.model.jobApplication;

@Service
public class EmailService {


	@Autowired
	JavaMailSender javaMailSender;

	public String emailVerify(String toEmailid){

		String otp = generateOtp();
		String subject = "Verification Code";
		String body = "Your account setup is almost complete! "
				+ "just click the link below to activate your account: \n\n\n" 
				+ "Your otp is : "+ otp + "\n\n\n\n\n\n\n" + 
				"Best Regards,\n"
				+ "The Job Portal Team";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("vintagecareer7@gmail.com");
		mailMessage.setTo(toEmailid);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return otp;

	}


	public String generateOtp() {
		UUID uuid = UUID.randomUUID();

		String uuidstring = uuid.toString();
		uuidstring = uuidstring.replace("-", "").toLowerCase();
		String otp = uuidstring.substring(0,6);

		return otp;
	}



	public String emailjobposted(String toEmailId,Jobpost jobpost){

		String subject = "Job posted Successfully";
		String body = "Hello " + jobpost.getPersonName()+ ",\n\n"
				+ "We are pleased to inform you that your job posting has been successfully submitted and is now live on our platform. "
				+ "This is an important step in finding the right candidates for your job opportunity.\n" 
				+ "Job Title: " + jobpost.getJobTitle()+ "\n"
				+ "Company: " + jobpost.getCompanyName() + "\n"
				+ "Location: " + jobpost.getLocation() + "\n"
				+ "Posted Date: " + new Date() + ".\n If you have any questions, need to make updates, or require further assistance," 
				+ "please feel free to contact our dedicated support team. We're here to help you make the most of your job posting. \n\n"
				+ "Thank you for choosing our platform to connect with potential candidates.\n\n" 
				+ "Best regards, VintageCareer.";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("vintagecareer7@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return null;
	}

	public String emailJobApplied(String toEmailId,jobApplication application ){

		String subject = "Job Applied successfully";
		String body =  "Hello " + application.getFullName() + ",\n\n" 
				+"Your job application has been successfully submitted.\n" 
				+ "Thank you for expressing interest.\n"
				+ "We will review your application and contact you if your qualifications match our requirements."
				+ "In the meantime, feel free to explore other opportunities on our platform."
				+ "If you have any questions or need further information, please do not hesitate to contact us."
				+ "We wish you the best of luck in your job search."
				+ "\n\n\n\n\n\n\n\n Best regards, VintageCareer.";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("vintagecareer7@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return null;
	}

	public String emailRegisteredUser(String toEmailId,User user){

		String subject = "User Registered successfully";
		String body = "Account Registration Successful" 
				+ "Hello" + user.getFullName() + "\n"
				+" Your account registration was successful.\n"
				+ "Welcome to VintageCareer, \n" 
				+ "We are excited to have you as a part of our community,"
				+ " and we look forward to providing you with valuable services and opportunities.\n"
				+ "Your Account Details:\n" 
				+ "Username: "+ user.getFullName() + "\n" 
				+ "Email: " + user.getEmailId() + "\n" 
				+ "Registration Date: " + new Date() + "\n" 
				+ "If you have any questions, encounter any issues, or need assistance,"
				+ " please don't hesitate to contact our support team. "
				+ "We're here to help you make the most of your account."
				+ "Thank you for choosing Vintage. We look forward to serving your needs.\n\n\n\n\n\n\n\n\n\n\n"
				+ "Best regards,\n" + "VintageCareer.";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("vintagecareer7@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return null;
	}

	public String emailRegisteredEmp(String toEmailId,Employee employee){

		String subject = "Employee Registered successfully";
		String body = "Account Registration Successful" 
				+ "Hello" + employee.getFullName() + "\n" 
				+" Your account registration was successful.\n"
				+ "Welcome to VintageCareer \n"
				+ "We are excited to have you as a part of our community,"
				+ " and we look forward to providing you with valuable services and opportunities.\n	"
				+ "Your Account Details:\n" 
				+ "Username: "+ employee.getFullName() + "\n" 
				+ "Email: " + employee.getEmailId() + "\n" 
				+ "Registration Date: " + new Date() + "\n" 
				+ "If you have any questions, encounter any issues, or need assistance,"
				+ " please don't hesitate to contact our support team. "
				+ "We're here to help you make the most of your account.\n\n"
				+ "Thank you for choosing VintageCareer. We look forward to serving your needs.\n\n\n\n\n\n\n\n"
				+ "Best regards,\n" + "VintageCareer.";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("vintagecareer7@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return null;
	}


}

package com.dao;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.CustomerOtp;
import com.model.Employee;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRespository employeeRespository;

	@Autowired
	CustomerOtp customerOtp;

	@Autowired
	JavaMailSender javaMailSender;

	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

	public Employee register(Employee emp){
		String bCryptpw = bCrypt.encode(emp.getPassword());
		emp.setPassword(bCryptpw);	
		return employeeRespository.save(emp);
	}

	public Employee login(String emailId,String password){
		Employee emp = employeeRespository.findByEmailId(emailId);

		if(bCrypt.matches(password, emp.getPassword())){
			return emp;
		}
		else{
			return null;
		}
	}


	public Employee userUpdate(String emailId,String password){
		Employee emp = employeeRespository.findByEmailId(emailId);
		emp.setPassword(bCrypt.encode(password));
		return employeeRespository.save(emp);
	}

	public boolean generateOTP(String emailId) {

		Employee emp = employeeRespository.findByEmailId(emailId);
		if(emp != null){

			Random random = new Random();
			int otp = 100000 + random.nextInt(900000);			
			LocalDateTime time = LocalDateTime.now().plusMinutes(2);

			customerOtp.setEmailOtp(otp);
			customerOtp.setEmailOtpExpiryTime(time);

			SimpleMailMessage msg = new SimpleMailMessage();

			msg.setTo(emailId);
			msg.setSubject("One Time Password");
			msg.setText("your otp is : "+otp);

			javaMailSender.send(msg);
			return true;

		}
		return false;

	}

	public boolean validateEmailOtp(String emailId, int otp) {
		Employee emp = employeeRespository.findByEmailId(emailId);
		if(emp != null) {
			if(customerOtp.getEmailOtp() == otp && customerOtp.getEmailOtpExpiryTime().isAfter(LocalDateTime.now())) {
				customerOtp.setEmailOtp(0);
				customerOtp.setEmailOtpExpiryTime(null);
				return true;
			}
		}
		return false;
	}


}

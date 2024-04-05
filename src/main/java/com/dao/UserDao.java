package com.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.CustomerOtp;
import com.model.User;

@Service
public class UserDao {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	JavaMailSender javaMailSender;

	CustomerOtp customerOtp = new CustomerOtp();

	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

	public User registerUser(User user){
		emailService.emailRegisteredUser(user.getEmailId(), user);
		String bCryptpw = bCrypt.encode(user.getPassword());
		user.setPassword(bCryptpw);	
		User user1= userRepository.save(user);
		return user1;
	}

	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public User loginUser(String EmailId, String password){
		User user = userRepository.findByEmailId(EmailId);

		if(bCrypt.matches(password, user.getPassword())){
			return user;
		}

		return null;
	}

	public User userUpdate(String emailId,String password){
		User user = userRepository.findByEmailId(emailId);
		user.setPassword(bCrypt.encode(password));
		return userRepository.save(user);
	}


	public User findByid(int id){
		return userRepository.findById(id).orElse(new User(0,"","","","",""));
	}

	public boolean generateOTP(String emailId) {
		User user = userRepository.findbyemailid(emailId);
		if(user != null){

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
		User user = userRepository.findbyemailid(emailId);
		if(user != null) {
			if(customerOtp.getEmailOtp() == otp && customerOtp.getEmailOtpExpiryTime().isAfter(LocalDateTime.now())) {
				customerOtp.setEmailOtp(0);
				customerOtp.setEmailOtpExpiryTime(null);
				return true;
			}
		}
		return false;
	}

}

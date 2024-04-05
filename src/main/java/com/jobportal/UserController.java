package com.jobportal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.EmailService;
import com.dao.UserDao;
import com.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserDao userdao;

	@Autowired
	EmailService emailService;

	@PostMapping("registeruser")
	public User register(@RequestBody User user){
		return userdao.registerUser(user) ;
	}

	@GetMapping("userLogin/{emailId},{password}")
	public User userLogin(@PathVariable("emailId") String emailID,@PathVariable("password") String password){
		return userdao.loginUser(emailID, password);
	}

	@GetMapping("finduser/{id}")
	public User finduser(@PathVariable("id") int id){
		User user = userdao.findByid(id);
		return user;
	}

	@GetMapping("getusers")
	public List<User> getUsers(){
		return userdao.getUsers();
	}


	@PutMapping("passwordReset/{emailId},{password}")
	public User userUpdate(@PathVariable("emailId") String emailId,@PathVariable("password") String password){
		return userdao.userUpdate(emailId, password);
	}

	@PostMapping("getEmailOtp")
	public ResponseEntity<Map<String, String>> EmailOtp(@RequestBody String emailId) {
		Map <String, String> response = new HashMap<>();
		if(userdao.generateOTP(emailId)) {
			response.put("message", "OTP is Sent");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}
	}

	@PutMapping("validateEmailOtp/{emailId}/{otp}")
	public ResponseEntity<Map<String, String>> validateEmailOtp(@PathVariable("emailId") String emailId, @PathVariable("otp") int otp) {
		Map <String, String> response = new HashMap<>();
		if(userdao.validateEmailOtp(emailId, otp)) {
			response.put("message", "OTP Verified");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}
	}
}

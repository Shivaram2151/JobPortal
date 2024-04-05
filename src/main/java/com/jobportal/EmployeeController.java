package com.jobportal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmailService;
import com.dao.EmployeeDao;
import com.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	EmailService emailservice;

	@PostMapping("EmployeeRegister")
	public Employee employeeRegister(@RequestBody Employee emp){
		Employee emp1 = employeeDao.register(emp);
		emailservice.emailRegisteredEmp(emp.getEmailId(), emp);
		return emp1;
	}

	@GetMapping("EmployeeLogin/{emailId},{password}")
	public Employee employeeLogin(@PathVariable("emailId") String emailid , @PathVariable("password") String password){
		return employeeDao.login(emailid, password);
	}

	@PutMapping("passwordResetemp/{emailId},{password}")
	public Employee userUpdate(@PathVariable("emailId") String emailId,@PathVariable("password") String password){
		return employeeDao.userUpdate(emailId, password);
	}

	@PostMapping("getEmailOtpemp")
	public ResponseEntity<Map<String, String>> EmailOtp(@RequestBody String emailId) {
		Map <String, String> response = new HashMap<>();
		if(employeeDao.generateOTP(emailId)) {
			response.put("message", "OTP is Sent");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}

	}

	@PutMapping("validateEmailemp/{emailId}/{otp}")
	public ResponseEntity<Map<String, String>> validateEmailOtp(@PathVariable("emailId") String emailId, @PathVariable("otp") int otp) {
		Map <String, String> response = new HashMap<>();
		if(employeeDao.validateEmailOtp(emailId, otp)) {
			response.put("message", "OTP Verified");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}
	}
}
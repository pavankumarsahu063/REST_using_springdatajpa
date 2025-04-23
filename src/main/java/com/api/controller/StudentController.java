package com.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Student;
import com.api.services.StudentServices;


import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentServices studentServices;
	
	

	public StudentController(StudentServices studentServices) {
		this.studentServices=studentServices;
	}
	
	@GetMapping("/login")
	public String home(@RequestBody Student student) {
		
		var s=studentServices.studentLogin(student);
		if(!Objects.isNull(s))
		return "Home Page";
		
		
		return "fail to login";
	}
	
	@GetMapping("/getcsrf")
	public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		if(studentServices.addStudent(student)!=null)
		return "Student Added";
		else{
			return "Failed ";
		}
	}
	
	@GetMapping("/allstudents")
	public List<Student> getStudents() {
		return studentServices.getAllStudents() != null ? studentServices.getAllStudents() :null;
	}
	
	@GetMapping("/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentServices.getStudentByEmail(email) != null ? studentServices.getStudentByEmail(email) : null;
	}
	
	@GetMapping("/email")
	public Student getStudentByParam(@RequestParam String email) {
		return studentServices.getStudentsByParam(email);
		
	}
	
	@DeleteMapping("delete/{email}")
	public String deleteStudent(@PathVariable String email) {
		if(studentServices.deleteByEmail(email)!=0) {
			return "Student Deleted";
		}
		return "Enter Valid Email";
	}
	
	@PutMapping("/update/{email}")
	public Student update(@PathVariable String email,@RequestBody Student student) {
		
		return studentServices.updateByemail(email, student);
	}
}

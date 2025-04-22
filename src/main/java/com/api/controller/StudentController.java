package com.api.controller;

import java.util.List;

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

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentServices studentServices;
	

	public StudentController(StudentServices studentServices) {
		this.studentServices=studentServices;
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home Page";
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

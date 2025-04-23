package com.api.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.Repository.StudentRepository;
import com.api.model.Student;

@Service
public class StudentServices {
	
	private StudentRepository studentRepository;


	public StudentServices(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	
	public Student getStudentsByParam(String email) {
		return studentRepository.findByEmail(email);
	}
	
	@Transactional
	public int deleteByEmail(String email) {
		return studentRepository.deleteByEmail(email);
	}
	
	@Transactional
	public Student updateByemail(String email,Student student) {
		Student s=studentRepository.findByEmail(email);
		
		if(s!=null) {
			s.setName(student.getName());
			s.setEmail(student.getEmail());
			s.setPassword(student.getPassword());
			
			return studentRepository.save(s);
		}
		return null;
		
	}
	
	public Student studentLogin(Student student) {
		return studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
	}
}

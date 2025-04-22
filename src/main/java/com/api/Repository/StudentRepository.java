package com.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByEmail(String email);
	int deleteByEmail(String email);
	

}
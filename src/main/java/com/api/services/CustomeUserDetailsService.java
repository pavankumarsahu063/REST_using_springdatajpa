package com.api.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.api.Repository.StudentRepository;

public class CustomeUserDetailsService implements UserDetailsService{
	
	private final StudentRepository studentRepository;
	
	public CustomeUserDetailsService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}

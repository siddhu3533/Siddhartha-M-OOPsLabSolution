package com.lab.email.service;

import com.lab.email.model.Employee;

public interface CredentialService {
	
		public String generateEmailAddress(Employee emp, String department);
		public String generatePassword(); 
		public void showCredentials(Employee emp,String email, String password);

}

package com.lab.email.service;

import java.util.Random;

import com.lab.email.model.Employee;

public class CredentialServiceImpl implements CredentialService {
	
	@Override
	public String generateEmailAddress(Employee emp, String department) {
		// TODO Auto-generated method stub
		String emailAddress = emp.getFirstName().toLowerCase()+emp.getLastName().toLowerCase()+"@"+department+".abc"+".com";
		return emailAddress;
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		String password;
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$%^&*_=+-/.?<>)";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] passwordTemp = new char[8];

	      passwordTemp[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      passwordTemp[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      passwordTemp[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      passwordTemp[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< 8 ; i++) {
	         passwordTemp[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
		password=new String(passwordTemp);
		return password;
	}

	@Override
	public void showCredentials(Employee emp,String email,String password) {
		// TODO Auto-generated method stub
		System.out.println("Dear "+emp.getFirstName()+" your generated credentials are as follows");
		System.out.println("Email    ---> "+email);
		System.out.println("Password ---> "+password);

	}

}

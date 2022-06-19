package com.lab.email.main;

import java.util.Scanner;

import com.lab.email.model.Employee;
import com.lab.email.service.CredentialService;
import com.lab.email.service.CredentialServiceImpl;


public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int departmentNumber;
		String firstName;
		String lastname;
		String department;
		System.out.println("Enter the first name");
		firstName = sc.next();
		System.out.println("Enter the last name");
		lastname = sc.next();
		Employee employee1 = new Employee(firstName,lastname);
		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resources");
		System.out.println("4. Legal");
		departmentNumber = sc.nextInt();
		switch(departmentNumber) {
		case 1: department = "tech";
				break;
		case 2: department = "admin";
				break;
		case 3: department = "hr";
				break;
		case 4: department = "legal";
				break;
		default: System.out.println("Invalid Department Number");
				sc.close();
				return;
		}
		CredentialService cred1 = new CredentialServiceImpl();
		String email = cred1.generateEmailAddress(employee1, department);
		String password = cred1.generatePassword();
		cred1.showCredentials(employee1,email,password);
		sc.close();
	}

}

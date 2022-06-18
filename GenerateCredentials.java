package siddhartha.oopsLabSolution;

import java.util.Random;
import java.util.Scanner;

class Employee{
	private String firstName;
	private String lastName;
	private String department;
	private String company = "abc";
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
class CredentialsService{
	
	private String emailAddress;
	private String password;
	//This method is used to generate email address in mentioned format.
	public void generateEmailAddress(String firstName, String lastName, String department, String company) {
		emailAddress = firstName.toLowerCase()+lastName.toLowerCase()+"@"+department+"."+company+".com";
	}
	//This method is used to generate password with a number, capital letter, small letter & special character.
	public void generatePassword() {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
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
	}
	//This method is used to show generated credentials. 
	public void showCredentials(String firstName) {
		System.out.println("Dear "+firstName+" your generated credentials are as follows");
		System.out.println("Email    ---> "+emailAddress);
		System.out.println("Password ---> "+password);
		}
}
public class GenerateCredentials {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int departmentNumber;
		Employee employee1 = new Employee("Harshit","Choudary");
		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resources");
		System.out.println("4. Legal");
		departmentNumber = sc.nextInt();
		switch(departmentNumber) {
		case 1: employee1.setDepartment("tech");
				break;
		case 2: employee1.setDepartment("admin");
				break;
		case 3: employee1.setDepartment("hr");
				break;
		case 4: employee1.setDepartment("legal");
				break;
		default: System.out.println("Invalid Department Number");
				return;
		}
		CredentialsService cred1 = new CredentialsService();
		cred1.generateEmailAddress(employee1.getFirstName(), employee1.getLastName(), employee1.getDepartment(), employee1.getCompany());
		cred1.generatePassword();
		cred1.showCredentials(employee1.getFirstName());
	}

}

import java.util.Scanner;
import java.io.*;

public class PhoneBookApplication {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		//the name of the file to open
		String fileName = "AdminLogin";
		
		//this will reference one line at a time
		String line = null;
		PhoneBookAdmin admin = null;
		String[] adminData;
		
		try{
			
			// FileReader reads text files in the default encoding
			FileReader fileReader = new FileReader(fileName);
			
			//always wrap FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				adminData = line.split(",");
				admin = new PhoneBookAdmin(adminData[0],adminData[1],adminData[2]);
			}
			
			//always close the file
			bufferedReader.close();	
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");	
		}
		
		catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		//the name of the file to open
		String fileName2 = "NormalLogin";
		
		//this will reference one line at a time
		String line2 = null;
		NormalUser normal = null;
		String[] normalData;
		
		try{
			
			// FileReader reads text files in the default encoding
			FileReader fileReader = new FileReader(fileName2);
			
			//always wrap FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				normalData = line.split(",");
				normal = new NormalUser(normalData[0],normalData[1],Integer.parseInt(normalData[2]));
			}
			
			//always close the file
			bufferedReader.close();	
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");	
		}
		
		catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		login(admin,normal);
		

	}
	public static void login(PhoneBookAdmin admin, NormalUser normal) {
		
		int userInput;
		
		System.out.println("Welcome to the Phone Book Application made by Dongjoo Lee!");
		System.out.println("\n-----Log in-----\n");
		System.out.print("What is your username?: ");
		String username = input.nextLine();
		System.out.print("What is your password?: ");
		String password = input.nextLine();
		if (username.equals(admin.username) && password.equals(admin.password)) {
			do {
				adminMenu();
				System.out.print("What would you like to do " + username + "? (enter number please): ");
				userInput = input.nextInt();
				if (userInput == 1) {
					System.out.print("\nEnter the Id: ");
					int Id = input.nextInt();
					System.out.print("Enter the first name: ");
					String firstName = input.next();
					System.out.print("Enter the last name: ");
					String lastName = input.next();
					System.out.print("Enter the email: ");
					String email = input.next();
					System.out.print("Enter the zip code: ");
					int zipCode=input.nextInt();
					System.out.print("Enter the phone number: ");
					String phoneNumber = input.next();
					input.nextLine();
					int result = admin.addEntry(new PhoneBookEntry(Id,firstName,lastName,email,zipCode,phoneNumber));
					if (result == 1) {
						System.out.println("\nNew entry successfully added");
					}
					else if (result != 1){
						System.out.println("\nThe phone book directory is full");
					}
				}
				else if (userInput == 2) {
					System.out.print("\nEnter the first name: ");
					String firstName = input.nextLine();
					System.out.print("Enter the last name: ");
					String lastName = input.nextLine();
					int result = admin.Edit(firstName,lastName);
					if (result == 1) {
						System.out.println("\nEntry successfully edited");
					}
					else if (result != 1){
						System.out.println("\nNo entry found...");
					}
				}
				else if (userInput == 3) {
					System.out.print("\nEnter the first name: ");
					String firstName = input.nextLine();
					System.out.print("Enter the last name: ");
					String lastName = input.nextLine();
					int result = admin.DeleteEntry(firstName,lastName);
					if (result == 1) {
						System.out.println("\nEntry successfully deleted");
					}
					else if (result != 1){
						System.out.println("\nNo entry found...");
					}
				}
				else if (userInput == 4) {
					admin.sortPhoneBook();
				}
				else if (userInput == 5) {
					System.out.print("\nEnter the phone number: ");
					String phoneNumber = input.nextLine();
					int result = admin.LinearSearchByPhoneNumber(phoneNumber);
					if (result == 1) {
						System.out.println("\nEntry successfully found");
					}
					else if (result != 1){
						System.out.println("\nNo entry found...");
					}
				}
				else if (userInput == 6) {
					System.out.print("\nEnter the Id: ");
					int Id = input.nextInt();
					PhoneBookEntry result = admin.SearchIdBinary(Id);
					if (result.getId() == -1) {
						System.out.println("\nEntry successfully found");
						result.printBookEntry();
					}
					else if (result.getId() == -1){
						System.out.println("\nNo entry found...");
					}
				}
				else if (userInput == 7) {
					admin.PrintUserInfo();
				}
				else if (userInput == 8) {
					System.out.print("\nEnter the new password: ");
					String newPassword = input.nextLine();
					admin.setPassword(newPassword);
				}
				else if (userInput == 9) {
					System.out.print("\nEnter the new username: ");
					String newUsername = input.nextLine();
					admin.setUsername(newUsername);
				}
				else if (userInput == 10) {
					System.out.println("\nThank you for using Dongjoo's Phone Book Application!");
				}
			}
			while(userInput != 10);
		}
		else if(username.equals(normal.username) && password.equals(normal.password)) {
			do {
				normalMenu();
				System.out.print("What would you like to do " + username + "? (enter number please): ");
				userInput = input.nextInt();
				if (userInput == 1) {
					System.out.print("\nEnter the Id: ");
					int Id = input.nextInt();
					System.out.print("Enter the first name: ");
					String firstName = input.nextLine();
					System.out.println("Enter the last name: ");
					String lastName = input.nextLine();
					System.out.print("Enter the email: ");
					String email = input.nextLine();
					System.out.print("Enter the zip code: ");
					int zipCode=input.nextInt();
					System.out.print("Enter the phone number: ");
					String phoneNumber = input.nextLine();
					input.nextLine();
					int result = normal.addEntry(new PhoneBookEntry(Id,firstName,lastName,email,zipCode,phoneNumber));
					if (result == 1) {
						System.out.println("\nNew entry successfully added");
					}
					else if (result != 1){
						System.out.println("\nThe phone book directory is full");
					}
				}
				else if (userInput == 2) {
					System.out.print("\nEnter the first name: ");
					String firstName = input.nextLine();
					System.out.print("Enter the last name: ");
					String lastName = input.nextLine();
					int result = normal.Edit(firstName,lastName);
					if (result == 1) {
						System.out.println("\nEntry successfully edited");
					}
					else if (result != 1){
						System.out.println("\nNo entry found...");
					}	
				}
				else if (userInput == 3) {
					normal.sortPhoneBook();
				}
				else if (userInput == 4) {
					System.out.print("\nEnter the phone number: ");
					String phoneNumber = input.nextLine();
					int result = normal.LinearSearchByPhoneNumber(phoneNumber);
					if (result == 1) {
						System.out.println("\nEntry successfully found");
					}
					else if (result != 1){
						System.out.println("\nNo entry found...");
					}
				}
				else if (userInput == 5) {
					normal.PrintUserInfo();
				}
				else if (userInput == 6) {
					System.out.println("Thank you for using Dongjoo's Phone Book Application!");
				}
			}
			while(userInput != 6);
		}
		else {
			System.out.println("No user of username: " + username + " and password: " + password + " found...");
		}
	}
	
	public static void adminMenu() {
		System.out.println("\n1. Add a phone entry");
		System.out.println("2. Edit a phone entry of a given first name and last name");
		System.out.println("3. Delete a phone entry of a given first name and last name");
		System.out.println("4. Sort the PhoneBookDirectory");
		System.out.println("5. Search using Linear Search");
		System.out.println("6. Search using Binary Search");
		System.out.println("7. Print Admin’s info");
		System.out.println("8. Change Password");
		System.out.println("9. Change Username");
		System.out.println("10. Exit");
	}
	
	public static void normalMenu() {
		System.out.println("\n1. Add a phone entry");
		System.out.println("2. Edit a phone entry of a given first name and last name");
		System.out.println("3. Sort the PhoneBookDirectory ");
		System.out.println("4. Search using Linear Search");
		System.out.println("5. Print user’s info");
		System.out.println("6. Exit");
	}
	
	public static int readAdmin() {
		//the name of the file to open
		String fileName = "AdminLogin.txt";
				
		//this will reference one line at a time
		String line = null;
		
		int returnValue = 0;
				
		try{
			// FileReader reads text files in the default encoding
			FileReader fileReader = new FileReader(fileName);
					
			//always wrap FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
					
			while((line = bufferedReader.readLine()) != null) {
				returnValue = 1;
			}
					
			//always close the file
			bufferedReader.close();	
		}
		catch(FileNotFoundException ex) {
			return returnValue;	
		}
		
		catch (IOException ex) {
			return returnValue;
			//or we could just do this
			//ex.printStackTrace();
		}
		return returnValue;
	}
	
	public static int readNormal() {
		//the name of the file to open
		String fileName = "NormalLogin.txt";
				
		//this will reference one line at a time
		String line = null;
		
		int returnValue = 0;
				
		try{
			// FileReader reads text files in the default encoding
			FileReader fileReader = new FileReader(fileName);
					
			//always wrap FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
					
			while((line = bufferedReader.readLine()) != null) {
				returnValue = 1;
			}
					
			//always close the file
			bufferedReader.close();	
		}
		catch(FileNotFoundException ex) {
			return returnValue;	
		}
		
		catch (IOException ex) {
			return returnValue;
			//or we could just do this
			//ex.printStackTrace();
		}
		return returnValue;
	}

}

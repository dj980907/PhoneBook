import java.util.Scanner;

public class PhoneBook {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int userInput;
		
		System.out.println("Welcome to Dongjoo's IPhone!");
		
		//instantiate 3 objects
		PhoneBookEntry[] iPhone = new PhoneBookEntry[3];
		
		//first object
		iPhone[0] = new PhoneBookEntry(5,"John", "Smith", "jsmith@gmail.edu",20037,"2023334444");
		
		//second object
		iPhone[1] = new PhoneBookEntry("James", "202344344");
		
		//third object
		iPhone[2] = new PhoneBookEntry("Sarah");
		
		do {
		
			System.out.println("\n1. Change the phone number of John Smith to 202555555");
			System.out.println("2. Print the attributes of John Smith using the method printBookEntry()");
			System.out.println("3. Assign the zip code of John Smith to James's");
			System.out.println("4. See all the entries");
			System.out.println("5. Exit");
			System.out.print("What would you like to do? (number plz): ");
			userInput = input.nextInt();
			
			if (userInput == 1) {
				//change the phone number of John Smith to 202555555
				iPhone[0].setPhoneNumber("202555555");
			}
			else if (userInput == 2) {
				//print the attributes of John Smith using the method printBookEntry()
				iPhone[0].printBookEntry();
			}
			else if(userInput == 3) {
				//Assign the zip code of John Smith to James's
				iPhone[1].setZipCode(iPhone[0].getZipCode());
			}
			else if (userInput == 4) {
				//just to check if the code is working, print out every object
				for (int i = 0; i < iPhone.length; i++) {
					iPhone[i].printBookEntry();
				}
			}
			else if(userInput == 5) {
				System.out.println("\nFirst part done!");
			}
			
		}
		while(userInput !=5);
		
	}
	
	

}

import java.util.Scanner;

public class PhoneBookDirectory {
	
	static Scanner input = new Scanner(System.in);

	//instantiate 6 objects
	private PhoneBookEntry[] iPhone = new PhoneBookEntry[6];
	//default
	public PhoneBookDirectory() {
		
	}
	
	//method that returns empty iPhone
	public PhoneBookEntry[] getPhoneBook() {
		return iPhone;
	}
	
	
	//add entry method
	public int addEntry(PhoneBookEntry entry) {
		//declare starting index as -1
		int index = -1;
		//go through the array and find the empty spot
		for (int i = 0; i < iPhone.length; ++i) {
			if (iPhone[i] == null || iPhone[i].getFirstName().isEmpty()) {
				index = i;
				break;
			}
		}
		//if the index is less than 0 it is full
		if (index < 0) {
			return 0;
		}
		//if not then we got to add entries
		else {
			iPhone[index] = entry;
			return 1;
		}
	}
	
	public void PrintAll() {
		System.out.println("User information\n");
		for (int i = 0; i < iPhone.length && iPhone[i] != null; i++) {
			if (iPhone[i].getFirstName()!= "") {
				iPhone[i].printBookEntry();
			}
		}
	}
	
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		//go through the loop to find the number
		for (int i = 0; i < iPhone.length && iPhone[i] != null; ++i) {
			//if the phone number user entered and stored phone is the same, 
			if (PhoneNumber == iPhone[i].getPhoneNumber()) {
				//return 1 if found
				return 1;
			}
		}
		return 0;
	}
	
	public PhoneBookEntry SearchIdBinary(int id) {
		//has to sort the array in order to do binary search
		sortPhoneBook();
		//declare mid index
		int midIndex;
		//declare low index as 0
		int lowIndex=0;
		//declare the high index
		int highIndex=iPhone.length-1;
		
		while (!(lowIndex>highIndex)){
			midIndex=(highIndex-lowIndex)/2+lowIndex;
			if (iPhone[midIndex].getId()<id) {
				lowIndex=midIndex+1;
			}else if (iPhone[midIndex].getId()>id) {
				highIndex=midIndex-1;
			}else {
				//return the matching PhoneBookEntry
				return iPhone[midIndex];
			}
		}
		//return empty PhoneBookEntry
		return new PhoneBookEntry(); 
	}
	
	public void sortPhoneBook() {
		//declare the minimum index
		int minIndex;
		//declare class phoneBookEntry class
		PhoneBookEntry temp;
		//order the array
		for (int order = 0; order < iPhone.length-1 && iPhone[order] != null; order++) {
			minIndex=order;
			for (int i = order+1; i < iPhone.length && iPhone[i] != null; i++) {
				if (iPhone[i].getId()<iPhone[minIndex].getId()) {
					minIndex=i;
				}
			}
			temp=iPhone[order];
			iPhone[order]=iPhone[minIndex];
			iPhone[minIndex]=temp;

		}
	}
	
	public int Edit(String firstName, String lastName) {
		for (int i = 0; i < iPhone.length && iPhone[i] != null; i++) {
			if (iPhone[i].getFirstName().equals(firstName) && iPhone[i].getLastName().equals(lastName)) {
				System.out.print("Enter the new ID: ");
				int Id = input.nextInt();
				System.out.print("Enter first name: ");
				String FirstName = input.next();
				System.out.print("Enter last name: ");
				String LastName=input.next();
				System.out.print("Enter the email: ");
				String email = input.next();
				System.out.print("Enter the zip code: ");
				int zipCode=input.nextInt();
				System.out.print("Enter the phone number: ");
				String phoneNumber = input.nextLine();
				input.nextLine();

				iPhone[i].setFirstName(FirstName);
				iPhone[i].setLastName(LastName);
				iPhone[i].setId(Id);
				iPhone[i].setEmail(email);
				iPhone[i].setZipCode(zipCode);
				iPhone[i].setPhoneNumber(phoneNumber);
				
				return 1;
			}
		}
		return 0;
	}
	
	public int DeleteEntry(int id) {
		PhoneBookEntry delId = SearchIdBinary(id);
		
		if (delId.getId()!=-1) {
			//set all attributes of the entry’s object to be deleted to default values
			delId.setFirstName("");
			delId.setLastName("");
			delId.setId(-1);
			delId.setEmail("");
			delId.setZipCode(0);
			delId.setPhoneNumber("");
			return 1;
		}
		return 0;

	}
	
}
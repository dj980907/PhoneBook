
public class PhoneBookAdmin extends User implements AdminInterface {
	
	public PhoneBookAdmin() {
		
	}

	public PhoneBookAdmin(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		
	}
	
	public int addEntry(PhoneBookEntry entry) {

		return directory.addEntry(entry);
	}
	
	public  int Edit(String firstName, String lastName) {
		return directory.Edit(firstName, lastName);
	}
	
	public int DeleteEntry(String firstName,String lastName) {
		PhoneBookEntry[]delEntry = directory.getPhoneBook();
		for (int i = 0; i < delEntry.length && delEntry[i] != null; i++) {
			if (delEntry[i].getFirstName().equals(firstName)&&delEntry[i].getLastName().equals(lastName)) {
				delEntry[i].setFirstName("");
				delEntry[i].setLastName("");
				delEntry[i].setId(-1);
				delEntry[i].setEmail("");
				delEntry[i].setZipCode(0);
				delEntry[i].setPhoneNumber("");
				return 1;
			}
		}
		return 0;
	}
	
	public void sortPhoneBook() {
		directory.sortPhoneBook();
	}
	
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		return directory.LinearSearchByPhoneNumber(PhoneNumber);
	}
	
	public  PhoneBookEntry SearchIdBinary(int Id) {
		return directory.SearchIdBinary(Id);
	}
	
	@Override
	public void PrintUserInfo() {
		System.out.println("\nUsername: "+username + "\nPassword: "+password+"\nEmail: "+email);
		//directory.PrintAll();
	}
	
	public  void setPassword(String password) {
		this.password = password;
	}
	
	public  void setUsername(String username) {
		this.username = username;
	}
}

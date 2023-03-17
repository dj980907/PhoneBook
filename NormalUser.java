
public class NormalUser extends User implements UserInterface {
	public NormalUser() {
		
	}
	public NormalUser(String username, String password, int Id) {
		super();
		this.username = username;
		this.password = password;
		this.Id = Id;
		
	}
	
	public  int addEntry(PhoneBookEntry entry) {
		int result = directory.addEntry(entry);
		return result;
	}
	
	public  int Edit(String firstName, String lastName) {
		int result = directory.Edit(firstName, lastName);
		return result;
	}
	
	public void sortPhoneBook() {
		directory.sortPhoneBook();
	}
	
	public  int LinearSearchByPhoneNumber(String PhoneNumber) {
		int result = directory.LinearSearchByPhoneNumber(PhoneNumber);
		return result;
	}
	
	@Override
	public void PrintUserInfo() {
		System.out.println("ID: " + Id +"\nUsername: " + username + "\nPassword: " + password);
		//directory.PrintAll();
		
	}
	
	
}

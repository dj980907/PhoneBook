
public class User {
	protected  String username;
	protected  String password;
	protected  String email;
	protected  int Id;
	protected  PhoneBookDirectory directory = new PhoneBookDirectory();
	
	//default constructor
	public User() {
		
	}
	
	//constructor that takes username, password, email and id
	protected User(String username,String password, String email,int Id) {

		this.username = username;
		this.password = password;
		this.email = email;
		this.Id = Id;
	}
	
	//method that prints out the user information
	public void PrintUserInfo() {
		System.out.println("Username: "+username + "\nPassword: "+password);
		
	}
	
}

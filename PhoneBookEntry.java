
public class PhoneBookEntry {
	private int Id = -1;
	private String firstName;
	private String lastName;
	private String email;
	private int zipCode;
	private String phoneNumber;
	
	//default constructor
	public PhoneBookEntry() {
		
	}
	//constructor that accepts only first name
	public PhoneBookEntry(String firstName) {
		this.firstName = firstName;
	}
	//constructor that only accepts first name and phone number
	public PhoneBookEntry(String firstName, String phoneNumber) {
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}
	//constructor that takes all attributes except id
	public PhoneBookEntry(String firstName, String lastName, String email, int zipCode, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		}
	//constructor that takes all attributes
	public PhoneBookEntry(int Id, String firstName, String lastName, String email, int zipCode, String phoneNumber) {
		this.Id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}
	//id getter
	public int getId() {
		return Id;
	}
	//id setter
	public void setId(int id) {
		Id = id;
	}
	//first name getter
	public String getFirstName() {
		return firstName;
	}
	//first name setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//last name getter
	public String getLastName() {
		return lastName;
	}
	//last name setter
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//email getter
	public String getEmail() {
		return email;
	}
	//email setter
	public void setEmail(String email) {
		this.email = email;
	}
	//zip code getter
	public int getZipCode() {
		return zipCode;
	}
	//zip code setter
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	//phone number getter
	public String getPhoneNumber() {
		return phoneNumber;
	}
	//phone number setter
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public void printBookEntry() {
		System.out.println("\nFirst Name " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nZip Code: " + zipCode + "\nPhone Number: " + phoneNumber);
	}
	
}

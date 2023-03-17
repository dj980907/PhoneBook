
public interface AdminInterface {
		
	public abstract int addEntry(PhoneBookEntry entry);
	public abstract int Edit(String firstName, String lastName);
	public abstract int DeleteEntry(String firstName,String lastName); 
	public abstract void sortPhoneBook();
	public abstract int LinearSearchByPhoneNumber(String PhoneNumber);
	public abstract PhoneBookEntry SearchIdBinary(int Id);
	public abstract void PrintUserInfo() ;
	public abstract void setPassword(String password);
	public abstract void setUsername(String username);
		
}


public interface UserInterface {
	public abstract int addEntry(PhoneBookEntry entry) ;
	public abstract int Edit(String firstName, String lastName) ;
	public abstract void sortPhoneBook();
	public abstract int LinearSearchByPhoneNumber(String PhoneNumber);
	public abstract void PrintUserInfo();
}

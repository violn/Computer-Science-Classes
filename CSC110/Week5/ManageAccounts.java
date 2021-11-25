// ************************************************************
// ManageAccounts.java
//
// Use Account class to create and manage Sally and Joe's
// bank accounts
// ************************************************************
public class ManageAccounts 
{
	public static void main(String[] args) 
	{
		Account[] accounts = new Account[]
		{
			new Account(1000, "Sally", 1111),
			new Account(500, "Joe", 1234),
			new Account(600, "Jill", 8989),	
			new Account(371, "Carey", 7596),	
			new Account(90, "David", 4947)
		};

		for(Account a: accounts)
		{
			//This to string can be exluded as the print statement converts it to a string
			System.out.println(a.toString());
			System.out.println(a.getBalance());
			System.out.println(a);
		}
	}
}

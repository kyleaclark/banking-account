
public class CurrentAccount extends Account {
	
	private final static int OVER_DRAFT_LIMIT = -300;
	
	public CurrentAccount(int accountNumber)
	{
	
	super(accountNumber);

	}
	
	public void overDraftCheck(Account tempAccount)
	{
		if(tempAccount.getBalance() <= OVER_DRAFT_LIMIT)
		{
			System.out.println("WARNING LETTER: YOU ARE IN OVERDRAFT!\n");
		}
	}
	
	public String toString()
	{
		return accountType() + " #" + getAccountNumber() + " HAS A BALANCE OF $" + getBalance();
	}
	
	public String accountType()
	{		
		return "CURRENT ACCOUNT";
	}
}

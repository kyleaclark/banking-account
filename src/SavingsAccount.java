
public class SavingsAccount extends Account {
	
	private double interest;
	
	public SavingsAccount(int accountNumber)
	{	
		super(accountNumber);
		this.interest = 0.019;
	}
	
	public void addInterest()
	{
		double savingsBalance = super.getBalance();
		savingsBalance += (savingsBalance * this.interest);
	}
	
	public String toString()
	{
		return accountType() + " #" + getAccountNumber() + " HAS A BALANCE OF $" + getBalance();
	}
	
	public String accountType()
	{		
		return "SAVINGS ACCOUNT";
	}
}


public class BankTest {
	
	public BankTest()	
	{
		
	}
	
	public static void main(String[] args)
	{				
		
		Bank banking = new Bank();
		//banking.deposit();
		//banking.withdraw();
		//banking.update();
		//banking.closingAccount();
		//banking.dividendTo();
		banking.openingAccount();
			
		//TEST TRANSFERTO()
		Account myAccount = new Account();
		SavingsAccount mySavings = new SavingsAccount(1000);
		System.out.println(mySavings.toString());
		myAccount.deposit(500);
		mySavings = (SavingsAccount)myAccount.transferTo(mySavings, 142.99);
		
		System.out.println(mySavings.summary());
		System.out.println(myAccount.summary());

	}

}

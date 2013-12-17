import java.util.Scanner;
import java.util.ArrayList;


public class Account {
	
	private int accountNumber;
	private double balance;
	
	private int transferTotal;
	
	public Account()
	{
		
	}
	
	public Account(int accountNumber)
	{
		this.accountNumber = accountNumber;
		this.balance = 0;
	}
	
	public void deposit()
	{
		Scanner keyboard = new Scanner(System.in);
		
		double depositValue = 0;
		
		do
		{
			System.out.println("ENTER A VALUE GREATER THAN 0 INTO YOUR ACCOUNT: ");
			depositValue = keyboard.nextInt();
		}while(depositValue <= 0);
		
		this.balance += depositValue;
	}
	
	public void deposit(double depositValue)
	{
		this.balance += depositValue;
	}
	
	public void withdraw()
	{
		Scanner keyboard = new Scanner(System.in);
		
		double withdrawValue = 0;
		
		do
		{
			System.out.println("ENTER A WITHDRAW VALUE GREATER THAN 0 INTO YOUR ACCOUNT: ");
			withdrawValue = keyboard.nextInt();
		}while(withdrawValue <= 0);
		
		this.balance -= withdrawValue;
	}
	
	public void withdraw(double withdrawValue)
	{
		this.balance -= withdrawValue;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public Account transferTo(Account tempAccount, double transferValue)
	{
		if(this.getBalance() > transferValue)
		{
			this.withdraw(transferValue);
			tempAccount.deposit(transferValue);
			this.transferTotal++;
		}
		else
		{
			System.out.println("ACCOUNT BALANCE TOO LOW -- TRANSFER NOT PROCESSED. TRY AGAIN.");
		}
		
		return tempAccount;
	}
	
	public String accountType()
	{		
		return "BASE ACCOUNT";
	}
	
	public String summary()
	{
		return this.accountType() + " #" + this.accountNumber + " HAS A BALANCE OF $" + this.balance + " # OF TRANSFERS: " + this.transferTotal;
	}
	
	public String toString()
	{

		return this.accountType() + " #" + this.accountNumber + " HAS A BALANCE OF $" + this.balance;
	}	

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bank {
	
	private ArrayList<Account> banking = new ArrayList<Account>();
	
	private int tempAccountNumber = 0;
	private int numberOfAccounts = 0;
	
	public Bank()
	{
		
		banking.add(new Account(1001));
		banking.add(new Account(1002));
		banking.add(new Account(1003));
		banking.add(new SavingsAccount(1004));
		banking.add(new SavingsAccount(1005));
		banking.add(new SavingsAccount(1006));
		banking.add(new CurrentAccount(1007));
		banking.add(new CurrentAccount(1008));
		banking.add(new CurrentAccount(1009));
		
		this.tempAccountNumber = 1010;
		this.numberOfAccounts = 9;
		
		Collections.shuffle(this.banking);
	}
	
	public void update()
	{
		Account bankingUpdate;
		
		for(int i = 0; i < this.banking.size(); i++)
		{
			bankingUpdate = this.banking.get(i);
			
			if(bankingUpdate.accountType().equals("BASE ACCOUNT"))
			{
				//DO NOTHING
			}
			else if(bankingUpdate.accountType().equals("SAVINGS ACCOUNT"))
			{				
				((SavingsAccount)(bankingUpdate)).addInterest();
			}
			else if(bankingUpdate.accountType().equals("CURRENT ACCOUNT"))
			{
				
				((CurrentAccount)(bankingUpdate)).overDraftCheck(bankingUpdate);
			}
		}
	}
	
	public void openingAccount()
	{
		Scanner keyboard = new Scanner(System.in);
		
		int addAccount = -1;

		do
		{
			System.out.println("DO YOU WANT TO OPEN A NEW ACCOUNT? ENTER 1 TO OPEN BASE, 2 TO OPEN SAVINGS, 3 TO OPEN CURRENT, OR 0 TO SAY NO.");
			addAccount = keyboard.nextInt();
			System.out.println(addAccount);
		}while((addAccount != 0) && (addAccount != 1) && (addAccount != 2) && (addAccount != 3));
			
		if(addAccount == 1)
		{
			this.tempAccountNumber++;
			this.banking.add(new Account(tempAccountNumber));
			this.numberOfAccounts++;
			Account tempBanking = this.banking.get(this.numberOfAccounts-1);
			System.out.println("ADDED: " + tempBanking.toString());
		}
		else if(addAccount == 2)
		{
			this.tempAccountNumber++;
			this.banking.add(new SavingsAccount(this.tempAccountNumber));
			this.numberOfAccounts++;
			Account tempBanking = this.banking.get(this.numberOfAccounts-1);
			System.out.println("ADDED: " + tempBanking.toString());
		}
		else if(addAccount == 3)
		{
			this.tempAccountNumber++;
			this.banking.add(new CurrentAccount(this.tempAccountNumber));
			this.numberOfAccounts++;
			Account tempBanking = this.banking.get(this.numberOfAccounts-1);
			System.out.println("ADDED: " + tempBanking.toString());
		}
	}
	
	public void closingAccount()
	{
		Scanner keyboard = new Scanner(System.in);
		
		Account bankingUpdate;
		
		int deleteAccount = -1;
		
		int loopUpdateSize = banking.size();
				
		for(int i = 0; i < loopUpdateSize; i++)
		{
			bankingUpdate = this.banking.get(i);
			
			System.out.println(bankingUpdate.toString());
			
			do
			{
			System.out.println("DO YOU WANT TO DELETE THIS ACCOUNT? ENTER 1 TO REMOVE OR 0 TO LEAVE OPEN.");
			deleteAccount = keyboard.nextInt();
			System.out.println(deleteAccount);
			}while((deleteAccount != 0) && (deleteAccount != 1));
			
			if(deleteAccount == 1)
			{
				this.banking.remove(i);
				loopUpdateSize--; //SUBTRACT 1 FROM THE LOOP SIZE TO ACCOUNT FOR SUBTRACTED ARRAY SIZE
				i--; //ARRAY SIZE IS 1 LESS SO INDEX NEEDS TO BE 1 LESS
				System.out.println(bankingUpdate.accountType() + " REMOVED\n");
			}
			
			deleteAccount = -1;
		}
	}
	
	public void dividendTo()
	{
		Scanner keyboard = new Scanner(System.in);
		
		Account bankingUpdate;
		
		int addDividend = -1;
		int dividendShares = 0;
		double dividendAmount = 0;

				
		for(int i = 0; i < this.banking.size(); i++)
		{
			bankingUpdate = this.banking.get(i);
			
			System.out.println(bankingUpdate.toString());
			
			do
			{
			System.out.println("DO YOU WANT TO ADD A DIVIDEND INTO THIS ACCOUNT? ENTER 1 TO ADD OR 0 TO SAY NO.");
			addDividend = keyboard.nextInt();
			}while((addDividend != 0) && (addDividend != 1));
			
			if(addDividend == 1)
			{
				
				do
				{
					System.out.println("HOW MANY SHARES?");
					dividendShares = keyboard.nextInt();
				}while(dividendShares <= 0);
				
				do
				{
					System.out.println("WHAT IS THE PRICE PER SHARE?");
					dividendAmount = keyboard.nextDouble();
				}while(dividendAmount <= 0);
				
				dividendAmount = dividendAmount * dividendShares;
				bankingUpdate.deposit(dividendAmount);
				System.out.println(bankingUpdate.toString() + "\n");
			}
			
			addDividend = -1;
		}
	}
}

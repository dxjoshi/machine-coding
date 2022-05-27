package bankingAppRazorPay.src;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String panNumber;
	private List<BankAccount> bankAccounts;
	
	
	public Customer(String panNumber) {
		this.panNumber = panNumber;
		this.bankAccounts = new ArrayList<>();
	}
	
	public void addBankAccount(BankAccount bankAccount) {
		this.bankAccounts.add(bankAccount);
	}
	
	public String getPanNumber() {
		return this.panNumber;
	}
	
	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}
	
}

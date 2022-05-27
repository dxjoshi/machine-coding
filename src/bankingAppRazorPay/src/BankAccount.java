package bankingAppRazorPay.src;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

	private final Double minimumBalance;
	private Double currentBalance;
	private final Double interestRate;
	private final String accountNumber;
	private List<Transaction> transactions;
	
	public BankAccount(final String accountNumber, final Double minimumBalance, final Double currentBalance, final Double interestRate) throws Exception {
        this.accountNumber = accountNumber;
        this.minimumBalance = minimumBalance;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        if (this.currentBalance < this.minimumBalance) throw new Exception();
        this.transactions = new ArrayList<>();
	}
	
	public void withdraw(final Double amount) throws Exception {
        if(currentBalance < amount) throw new Exception();
        currentBalance -= amount;
        transactions.add(new Transaction(accountNumber, amount, "withdraw"));
	}
	
	public void deposit(final Double amount) throws Exception {
        if(amount < 0D) {
            throw new Exception();
        }
        currentBalance += amount;
        transactions.add(new Transaction(accountNumber, amount, "deposit"));
	}
	
	public List<Transaction> getTransactionHistory(){
		return this.transactions;
	}
	
	public List<Transaction> getMiniStatement(){
        final int len = transactions.size();
		return transactions.subList(len-10, len);
	}
	
	public Double getMinimumBalance() {
		return this.minimumBalance;
	}
	
	public Double getCurrentBalance() {
		return this.currentBalance;
	}
	
	public Double getInterestRate() {
		return this.interestRate;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public abstract String getType();
		
}

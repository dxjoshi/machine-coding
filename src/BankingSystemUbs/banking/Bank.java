package BankingSystemUbs.banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	Long accountNumber;
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		this.accountNumber = 1L;
		this.accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long newAccountNumber = accountNumber;
		Account commercialAccount = new CommercialAccount(company, newAccountNumber, pin, startingDeposit);
		accounts.put(newAccountNumber, commercialAccount);
		accountNumber += 1;
		return newAccountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long newAccountNumber = accountNumber;
		Account consumerAccount = new ConsumerAccount(person, newAccountNumber, pin, startingDeposit);
		accounts.put(newAccountNumber, consumerAccount);
		accountNumber += 1;
		return newAccountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = accounts.get(accountNumber);
		return account.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		Account account = accounts.get(accountNumber);
		return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		return account.debitAccount(amount);
	}
}

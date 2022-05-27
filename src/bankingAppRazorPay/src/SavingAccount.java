package bankingAppRazorPay.src;

public class SavingAccount extends BankAccount {

	public SavingAccount(String accountNumber, Double currentBalance) throws Exception {
		super(accountNumber, 10000D, currentBalance, 4.5D);
	}

	public String getType() {
		return "Saving";
	}
}

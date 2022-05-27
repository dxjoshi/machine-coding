package bankingAppRazorPay.src;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(String accountNumber, Double currentBalance) throws Exception {
        super(accountNumber, 20000D, currentBalance, 0D);
	}

	public String getType() {
		return "Current";
	}
}

package bankingAppRazorPay.src;

import java.util.ArrayList;
import java.util.List;

public class Branch {
	
	private String branchId;
	private List<BankAccount> bankAccounts;
    private List<Customer> customers;
    private Integer accId;
	
	
	public Branch(String id) {
        this.branchId = id;
        this.accId = 1;
        this.bankAccounts = new ArrayList<>();
        this.customers = new ArrayList<>();
	}
	
	public Customer getCustomerByPan(String panNumber) throws Exception {
        Customer res = null;
        for(Customer customer : customers) {
            if (customer.getPanNumber().equals(panNumber)) {
                res = customer;
            }
        }
        if (res == null) throw new Exception();
        return res;
        
	}
	
	public BankAccount getAccountByAccountNumber(String accountNumber) throws Exception {
		BankAccount res = null;
        for(BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                res = account;
            }
        }
        if (res == null) throw new Exception();
        return res;
	}
	
	public BankAccount createBankAccount(String panNumber, String type, Double balance) throws Exception {
        if (balance < 0D ) throw new Exception();
        BankAccount account = null;
        if ("Saving".equals(type)) {
            account = new SavingAccount(String.valueOf(accId), balance);
        } else if("Current".equals(type)) {
            account = new CurrentAccount(String.valueOf(accId), balance);
        }
        accId += 1;

        Customer customer = null;
        try {
            customer = getCustomerByPan(panNumber);
        } catch(Exception ex) {
            customer = new Customer(panNumber);
            customers.add(customer);
        }
        customer.addBankAccount(account);
        bankAccounts.add(account);
        return account;
    }
	
	
	public String getId() {
		return this.branchId;
	}
	
}

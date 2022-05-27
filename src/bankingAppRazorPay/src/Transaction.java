package bankingAppRazorPay.src;


public class Transaction {

	private String transactionId;
	private Double amount;
	private String type;
	
	public Transaction(String transactionId, Double amount, String type) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
	}
	
	public String getTransactionId() {
		return this.transactionId;
	}
	
	public Double getAmount() {
		return this.amount;
	}
	
	public String getType() {
		return this.type;
	}
}

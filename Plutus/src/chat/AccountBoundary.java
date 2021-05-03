package chat;

public class AccountBoundary {
	private BankingTransactionBoundary theTransaction;
	private String accountNumber;
	private String bankID;
	private String branch;
	private String customerName;
	
	public BankingTransactionBoundary getTheTransaction() {
		return theTransaction;
	}
	public void setTheTransaction(BankingTransactionBoundary theTransaction) {
		this.theTransaction = theTransaction;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}

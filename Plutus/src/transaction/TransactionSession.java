package transaction;

import main.Main;
import p2p.banking.BankingInterchange;

public class TransactionSession implements AutoCloseable{
	private String myID;
	private TransactionCtrl ctrl;
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public TransactionSession(String myID, String... config) {
		super();
		ctrl = new TransactionCtrl(); 
		this.myID = myID;
		this.interchange = new BankingInterchange<BankingTransactionBoundary>(this.myID, config, this::handleMessage, new BankingTransactionBoundary());
	}

	public void sendMoney(BankingTransactionBoundary trans) {
		this.interchange.sendBankingTransaction(trans);
		System.err.println("send money");
	}

	
	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}

	public void handleMessage (BankingTransactionBoundary trans) {
		if (trans.getDestination().getBankID().equals(this.myID)) 
			ctrl.receivingMoney(trans);
	}

}



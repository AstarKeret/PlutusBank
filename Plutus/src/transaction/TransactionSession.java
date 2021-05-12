package transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.ManagmentSystem;
import model.TransactionCtrl;
import p2p.banking.BankingInterchange;

public class TransactionSession implements AutoCloseable{
	private String myID;
	private TransactionCtrl ctrl;
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public TransactionSession(String bankID, String... config) {
		super();
		ctrl = new TransactionCtrl(); 
		this.myID = bankID;
		this.interchange = new BankingInterchange<BankingTransactionBoundary>(this.myID, config, this::handleMessage, new BankingTransactionBoundary());
	}

	public void sendMoney(BankingTransactionBoundary trans) {
		this.interchange.sendBankingTransaction(trans);
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

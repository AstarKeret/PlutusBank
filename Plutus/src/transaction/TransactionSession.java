package transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import p2p.banking.BankingInterchange;

public class TransactionSession implements AutoCloseable{
	private String myID;
//	private SimpleDateFormat formatter;
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public TransactionSession(String bankID, String... config) {
		super();
		this.myID = bankID;
//		this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.interchange = new BankingInterchange<BankingTransactionBoundary>(this.myID, config, this::handleMessage, new BankingTransactionBoundary());
	}

	public void sendMoney(BankingTransactionBoundary trans) {
		this.interchange.sendBankingTransaction(trans);
	}

	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}
	
	//if its ours transaction or not
	public void handleMessage (BankingTransactionBoundary trans) {
		if (trans.getDestination().getBankID().equals(this.myID)) {
			//add receiving money
		}else {

		}
	}

}

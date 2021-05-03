package chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import p2p.banking.BankingInterchange;

public class ChatSession implements AutoCloseable{
	public final String MY_ID = "8";
	private SimpleDateFormat formatter;
	
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public ChatSession(String account,String bankID, String branch, String name, String... config) {
		super();
		this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.interchange = new BankingInterchange<BankingTransactionBoundary>(bankID, config, this::handleMessage, new BankingTransactionBoundary());
	}
	
	public void setAmount(double amount) {
		BankingTransactionBoundary trans = new BankingTransactionBoundary();
//		trans.set(this.email);
//		trans.setTimestamp(new Date());
//		trans.setContnet(content);
		
		this.interchange.sendBankingTransaction(trans);
	}

	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}
	
	//if its ours transaction or not
	public void handleMessage (BankingTransactionBoundary trans) {
		if (trans.getDestination().getBankID().equals(MY_ID)) {
//			System.err.println("(" + message.getContnet() + ")");
		}else {
//			System.err.println("" + message.getSender() + ": " + message.getContnet() + " (" + this.formatter.format(message.getTimestamp()) + ")");
		}
	}
}

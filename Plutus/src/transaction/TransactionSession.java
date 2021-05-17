package transaction;

import p2p.banking.BankingInterchange;

public class TransactionSession implements AutoCloseable{
	private String myID;
	private TransactionCtrl ctrl;
	private BankingInterchange<BankingTransactionBoundary> interchange;

	public TransactionSession(String bankID, String... config) {
		super();
		ctrl = new TransactionCtrl(); 
		myID = bankID;
		interchange = new BankingInterchange<BankingTransactionBoundary>(this.myID, config, this::handleMessage, new BankingTransactionBoundary());
	}

	public void sendMoney(BankingTransactionBoundary trans) {
		this.interchange.sendBankingTransaction(trans);
	}

	
	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}

	public void handleMessage (BankingTransactionBoundary trans) {
		System.err.println("a");
		if (trans.getDestination().getBankID().equals(this.myID)) 
		{
			System.err.println("myID");
			ctrl.receivingMoney(trans);
		}
		else
			System.err.println("not myID");
	}

	
	/*
	 * 	
	private BankingInterchange<ChatMessage> interchange;

	public ChatSession(String email, String... config) {
		super();
		this.email = email;
		this.formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.interchange = new BankingInterchange<ChatMessage>(this.email, config, this::handleMessage, new ChatMessage());
	}
	
	public void sendMessage(String content) {
		ChatMessage message = new ChatMessage();
		message.setSender(this.email);
		message.setTimestamp(new Date());
		message.setContnet(content);
		
		this.interchange.sendBankingTransaction(message);
	}

	@Override
	public void close() throws Exception {
		this.interchange.close();		
	}
	
	public void handleMessage (ChatMessage message) {
		if (this.email.equals(message.getSender())) {
			System.err.println("(" + message.getContnet() + ")");
		}else {
			System.err.println("" + message.getSender() + ": " + message.getContnet() + " (" + this.formatter.format(message.getTimestamp()) + ")");
		}
	}
	 */
}



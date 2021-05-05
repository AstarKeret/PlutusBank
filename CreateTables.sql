
CREATE DATABASE plutus

USE plutus;
CREATE TABLE Customer(
	CustomerNumber INT NOT NULL IDENTITY(1,1),
	FirstName VARCHAR(30) NOT NULL,
	SurName VARCHAR(30) NOT NULL,
	UsertName VARCHAR(30) NOT NULL,
	Cpassword VARCHAR(30) NOT NULL,
	Gender VARCHAR(6) NOT NULL CHECK (Gender IN('Female', 'male')),
	DOB DATE,
	PhoneNumber VARCHAR(20),
	CONSTRAINT pk_cutomer PRIMARY KEY(CustomerNumber)
);

USE plutus;
CREATE TABLE Account(
	AccountNumber INT NOT NULL IDENTITY(1,1),
	Balance NUMERIC NOT NULL DEFAULT 0.00,
	OpenDate DATE NOT NULL DEFAULT getdate(),
	CONSTRAINT pk_account PRIMARY KEY(AccountNumber)
);

USE plutus;
CREATE TABLE Customer_Account(
	CustomerNumber INT NOT NULL,
	AccountNumber INT NOT NULL,
	CONSTRAINT pk_accountCustomer PRIMARY KEY(CustomerNumber,AccountNumber),
	CONSTRAINT fk_account FOREIGN KEY (AccountNumber) REFERENCES Account(AccountNumber)
	ON UPDATE CASCADE
	ON DELETE NO ACTION,
	CONSTRAINT fk_customer FOREIGN KEY (CustomerNumber) REFERENCES Customer(CustomerNumber)
	ON UPDATE CASCADE
	ON DELETE NO ACTION
);

USE plutus;
CREATE TABLE Transactions(
	SerialNumber int NOT NULL IDENTITY(1,1),
	accountNumber CHAR NOT NULL,
	BankID CHAR NOT NULL, 
	Branch CHAR DEFAULT NULL,
	CustomerName VARCHAR(30) NOT NULL,
	Comment CHAR,
	tTimeStamp DATE NOT NULL DEFAULT getdate(),
	Amount NUMERIC NOT NULL,
	CONSTRAINT pk_transaction PRIMARY KEY(SerialNumber)
)

USE plutus;
CREATE TABLE Account_Transactions(
	AccountNumber INT NOT NULL,
	SerialNumber int NOT NULL,
	CONSTRAINT pk_AccountTransactions PRIMARY KEY(AccountNumber, SerialNumber),
	CONSTRAINT fk_account2 FOREIGN KEY (AccountNumber) REFERENCES Account(AccountNumber)
	ON UPDATE CASCADE
	ON DELETE NO ACTION,
	CONSTRAINT fk_transactions FOREIGN KEY (SerialNumber) REFERENCES Transactions(SerialNumber)
	ON UPDATE CASCADE
	ON DELETE NO ACTION
)

USE plutus;
CREATE TABLE Employee(
	EmployeeNumber int IDENTITY(1,1),
	FirstName VARCHAR(30) NOT NULL,
	SurName VARCHAR(30) NOT NULL,
	UsertName VARCHAR(30) NOT NULL,
	Epassword VARCHAR(30) NOT NULL,
	Etype VARCHAR(7) NOT NULL CHECK (Etype IN('Manager', 'Regular')),
	CONSTRAINT pk_employee PRIMARY KEY(EmployeeNumber)
);




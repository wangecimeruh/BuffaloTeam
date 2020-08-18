package com.ngechu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions_table")

public class TransactionBean {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String cardNumber;
	
	@Column	
	private String amount;	
	public TransactionBean() {
		// Non-argument constructor
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	

	

}

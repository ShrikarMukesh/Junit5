package com.training.model;

public class CreditCard {

	private int cardNo;
	private int validUptoMonth;
	private int validUptoYear;
	private int cvv;

	public CreditCard() {
		super();
	}

	public CreditCard(int cardNo, int validUptoMonth, int validUptoYear, int cvv) {
		super();
		this.cardNo = cardNo;
		this.validUptoMonth = validUptoMonth;
		this.validUptoYear = validUptoYear;
		this.cvv = cvv;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public int getValidUptoMonth() {
		return validUptoMonth;
	}

	public void setValidUptoMonth(int validUptoMonth) {
		this.validUptoMonth = validUptoMonth;
	}

	public int getValidUptoYear() {
		return validUptoYear;
	}

	public void setValidUptoYear(int validUptoYear) {
		this.validUptoYear = validUptoYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}

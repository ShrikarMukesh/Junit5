package com.training.model;

public class Customer {

	private int id;
	private String name;
	private String contact;
	private Wallet wallet;

	public Customer() {
		super();
	}

	public Customer(int id, String name, String contact, Wallet wallet) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.wallet = wallet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}

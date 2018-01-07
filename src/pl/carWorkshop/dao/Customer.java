package pl.carWorkshop.dao;

import java.sql.Timestamp;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private Timestamp birthDate;
	
	public Customer() {}

	public Customer(int id, String firstName, String lastName, Timestamp birthDate) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}
	
	

}

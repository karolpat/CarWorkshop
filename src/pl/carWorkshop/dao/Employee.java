package pl.carWorkshop.dao;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
	private String note;
	private double workHourCost;
	
	public Employee() {}
	
	

	public Employee(String firstName, String lastName, String address, int phoneNumber, String note,
			double workHourCost) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setNote(note);
		this.setWorkHourCost(workHourCost);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getFirstName()).append("  ").append(this.getLastName()).append("  ").append(this.getPhoneNumber()).append("  ").append(this.getWorkHourCost());
		return sb.toString();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getWorkHourCost() {
		return workHourCost;
	}

	public void setWorkHourCost(double workHourCost) {
		this.workHourCost = workHourCost;
	}
}

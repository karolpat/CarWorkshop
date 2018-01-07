package pl.carWorkshop.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Year;

public class Vehicle {

	private int id;
	private String model;
	private String brand;
	private Year productionYear;
	private String registNumber;
	private Timestamp reviewDate;

	public Vehicle() {
	}

	public Vehicle(String model, String brand, Year productionYear, String registNumber, Timestamp reviewDate) {
		this.setModel(model);
		this.setBrand(brand);
		this.setProductionYear(productionYear);
		this.setRegistNumber(registNumber);
		this.setReviewDate(reviewDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getBrand()).append("   ").append(this.getModel()).append("   ").append(this.getProductionYear());
		return super.toString();
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Year getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Year productionYear) {
		this.productionYear = productionYear;
	}

	public String getRegistNumber() {
		return registNumber;
	}

	public void setRegistNumber(String registNumber) {
		this.registNumber = registNumber;
	}

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

}

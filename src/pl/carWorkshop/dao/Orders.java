package pl.carWorkshop.dao;

import java.sql.Date;
import java.sql.Timestamp;

public class Orders {
	
	private int id;
	private Timestamp orderDate;
	private Timestamp plannedStartDate;
	private Timestamp startDate;
	private int employee_id;
	private String problemDesc;
	private String fixDesc;
	private int status_id;
	private int car_id;
	private double fixCost;
	private double partsCost;
	private double workHourCost;
	
	
	public Orders() {}
	
	


	public Orders(Timestamp orderDate, Timestamp plannedStartDate, Timestamp startDate, int employee_id,
			String problemDesc, String fixDesc, int status_id, int car_id, double fixCost, double partsCost,
			double workHourCost) {
		
		this.setOrderDate(orderDate);
		this.setPlannedStartDate(plannedStartDate);
		this.setStartDate(startDate);
		this.setEmployee_id(employee_id);
		this.setProblemDesc(problemDesc);
		this.setFixDesc(fixDesc);
		this.setStatus_id(status_id);
		this.setCar_id(car_id);
		this.setFixCost(fixCost);
		this.setPartsCost(partsCost);
		this.setWorkHourCost(workHourCost);
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}


	public Timestamp getPlannedStartDate() {
		return plannedStartDate;
	}


	public void setPlannedStartDate(Timestamp plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getProblemDesc() {
		return problemDesc;
	}


	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}


	public String getFixDesc() {
		return fixDesc;
	}


	public void setFixDesc(String fixDesc) {
		this.fixDesc = fixDesc;
	}


	public int getStatus_id() {
		return status_id;
	}


	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public double getFixCost() {
		return fixCost;
	}


	public void setFixCost(double fixCost) {
		this.fixCost = fixCost;
	}


	public double getPartsCost() {
		return partsCost;
	}


	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}


	public double getWorkHourCost() {
		return workHourCost;
	}


	public void setWorkHourCost(double workHourCost) {
		this.workHourCost = workHourCost;
	}
	
	

}

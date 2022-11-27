package by.grsu.rkarachun.tsm.web.dto;

import java.sql.Timestamp;

public class OrdDto {
	private Integer id;

	private Integer clientId;
	
	private String clientName;

	private Integer carId;
	
	private String carName;

	private Integer price;

	private Integer distance;

	private Timestamp orderTime;

	private Timestamp arrivalTime;

	private Timestamp orderFinish;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Timestamp getOrderFinish() {
		return orderFinish;
	}

	public void setOrderFinish(Timestamp orderFinish) {
		this.orderFinish = orderFinish;
	}


}

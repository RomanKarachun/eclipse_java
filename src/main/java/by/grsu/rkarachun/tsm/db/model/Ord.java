package by.grsu.rkarachun.tsm.db.model;

import java.sql.Timestamp;

public class Ord {
	private Integer id;

	private Integer clientId;

	private Integer carId;

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

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
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

	@Override
	public String toString() {
		return "Ord [id=" + id + ", clientId=" + clientId + ", carId=" + carId + ", price=" + price + ", distance="
				+ distance + ", orderTime=" + orderTime + ", arrivalTime=" + arrivalTime + ", orderFinish="
				+ orderFinish + "]";
	}

}
